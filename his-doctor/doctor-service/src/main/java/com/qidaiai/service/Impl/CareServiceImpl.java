package com.qidaiai.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.qidaiai.constants.Constants;
import com.qidaiai.domain.*;
import com.qidaiai.dto.CareHistoryDto;
import com.qidaiai.dto.CareOrderDto;
import com.qidaiai.dto.CareOrderFormDto;
import com.qidaiai.dto.CareOrderItemDto;
import com.qidaiai.mapper.*;
import com.qidaiai.service.CareService;
import com.qidaiai.service.impl.MedicinesService;
import com.qidaiai.utils.IdGeneratorSnowflake;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CareServiceImpl implements CareService {

    @Autowired
    private CareHistoryMapper careHistoryMapper;

    @Autowired
    private CareOrderMapper careOrderMapper;

    @Autowired
    private CareOrderItemMapper careOrderItemMapper;

    @Autowired
    private RegistrationMapper registrationMapper;

    @Reference
    private MedicinesService medicinesService;

    @Autowired
    private OrderChargeItemMapper orderChargeItemMapper;

    @Override
    public List<CareHistory> queryCareHistoryByPatientId(String patientId) {
        //自定义sql语句
        return this.careHistoryMapper.selectListBySql(patientId);
    }

    @Override
    public CareHistory saveOrUpdateCareHistory(CareHistoryDto careHistoryDto) {
        CareHistory careHistory=new CareHistory();
        BeanUtil.copyProperties(careHistoryDto,careHistory);
        if (StringUtils.isNotBlank(careHistory.getChId())) {
            this.careHistoryMapper.updateById(careHistory);
        } else {
            careHistory.setChId(IdGeneratorSnowflake.generatorIdWithProfix(Constants.ID_PROFIX_CH));
            this.careHistoryMapper.insert(careHistory);
        }
        return careHistory;
    }

    @Override
    public CareHistory queryCareHistoryByRegId(String regId) {
        QueryWrapper<CareHistory> qw=new QueryWrapper<>();
        qw.eq(CareHistory.COL_REG_ID,regId);
        return (CareHistory) this.careHistoryMapper.selectOne(qw);
    }

    @Override
    public List<CareOrder> queryCareOrdersByChId(String chId) {
        //自定义sql语句
        return this.careOrderMapper.selectListBySql(chId);
    }

    @Override
    public List<CareOrderItem> queryCareOrderItemsByCoId(String coId, String status) {
//        QueryWrapper<CareOrderItem> qw=new QueryWrapper<>();
//        qw.eq(CareOrderItem.COL_CO_ID,coId);
//        qw.eq(StringUtils.isNotBlank(status),CareOrderItem.COL_STATUS,status);
        //自定义查询语句
        return this.careOrderItemMapper.selectListBySql(coId,status);
//        return this.careOrderItemMapper.selectList(qw);
    }

    @Override
    public CareHistory queryCareHistoryByChId(String chId) {
        return this.careHistoryMapper.selectById(chId);
    }

    @Override
    public int saveCareOrderItem(CareOrderFormDto careOrderFormDto) {
        CareOrderDto careOrderDto = careOrderFormDto.getCareOrder();
        CareOrder careOrder=new CareOrder();
        BeanUtil.copyProperties(careOrderDto,careOrder);
        careOrder.setCreateBy(careOrderDto.getSimpleUser().getUserName());
        careOrder.setCreateTime(DateUtil.date());
        int i=this.careOrderMapper.insert(careOrder);//保存处方主表
        List<CareOrderItemDto> careOrderItems = careOrderFormDto.getCareOrderItems();
        //保存详情数据
        for (CareOrderItemDto careOrderItemDto : careOrderItems) {
            CareOrderItem careOrderItem=new CareOrderItem();
            BeanUtil.copyProperties(careOrderItemDto,careOrderItem);
            careOrderItem.setCoId(careOrder.getCoId());
            careOrderItem.setCreateTime(DateUtil.date());
            careOrderItem.setStatus(Constants.ORDER_DETAILS_STATUS_0);//未支付
            careOrderItem.setItemId(IdGeneratorSnowflake.generatorIdWithProfix(Constants.ID_PROFIX_ITEM));
            this.careOrderItemMapper.insert(careOrderItem);
        }
        return i;
    }

    @Override
    public CareOrderItem queryCareOrderItemByItemId(String itemId) {
        return this.careOrderItemMapper.selectById(itemId);
    }


    @Override
    public int deleteCareOrderItemByItemId(String itemId) {
        //注意点，如果删除了，要更新careOrder主表的all_amount
        CareOrderItem careOrderItem=this.careOrderItemMapper.selectById(itemId);
        String coId=careOrderItem.getCoId();//取出主表ID
        //删除
        int i=this.careOrderItemMapper.deleteById(itemId);

        //再根据coID查询还存在的详情数据
        QueryWrapper<CareOrderItem> qw=new QueryWrapper<>();
        qw.eq(CareOrderItem.COL_CO_ID,coId);
        List<CareOrderItem> careOrderItems=this.careOrderItemMapper.selectList(qw);
        if(careOrderItems!=null&&careOrderItems.size()>0){
            //重新计算总价格
            BigDecimal allAmount=new BigDecimal("0");
            for (CareOrderItem orderItem : careOrderItems) {
                allAmount=allAmount.add(orderItem.getAmount());
            }
            //再根据coId查询主表的数据
            CareOrder careOrder=this.careOrderMapper.selectById(coId);
            //更新主表的数据
            careOrder.setAllAmount(allAmount);
            this.careOrderMapper.updateById(careOrder);
        }else{
            //说明没有详情了，直接干掉主表里面的数据
            this.careOrderMapper.deleteById(coId);
        }
        return i;
    }

    @Override
    public int visitComplete(String regId) {
//        Registration registration=new Registration();
//        registration.setRegId(regId);
//        registration.setRegStatus(Constants.REG_STATUS_3);
//        return this.registrationMapper.updateById(registration);
        //自定义修改就诊状态
        return this.registrationMapper.updateByIdSql(regId,Constants.REG_STATUS_3);
    }

    /**
     * 发药
     * 思路
     * 1，根据详情ID查询处方项目
     * 2，扣减库存(如果库存够就扣减 返回受影响的行数，如果不够就返回0)
     * 3，如果返回0 说是库存不够，停止发药
     * 4，如果返回>0 更新处方详情   支持详情的状态 为3
     * @param itemIds
     * @return
     */
    @Override
    public String doMedicine(List<String> itemIds) {
        //根据详情ID查询处方详情
        QueryWrapper<CareOrderItem> qw=new QueryWrapper<>();
        qw.in(CareOrderItem.COL_ITEM_ID,itemIds);
        List<CareOrderItem> careOrderItems = this.careOrderItemMapper.selectList(qw);
        StringBuffer sb=new StringBuffer();
        for (CareOrderItem careOrderItem : careOrderItems) {
            //库存扣减
            int i=this.medicinesService.deductionMedicinesStorage(Long.valueOf(careOrderItem.getItemRefId()),careOrderItem.getNum().longValue());
            if(i>0){//说明库存够
                //更新处方详情状态
                careOrderItem.setStatus(Constants.ORDER_DETAILS_STATUS_3);//已完成
                this.careOrderItemMapper.updateById(careOrderItem);
                //更新收费详情状态
                OrderChargeItem orderChargeItem=new OrderChargeItem();
                orderChargeItem.setItemId(careOrderItem.getItemId());
                orderChargeItem.setStatus(Constants.ORDER_DETAILS_STATUS_3);
                this.orderChargeItemMapper.updateById(orderChargeItem);
            }else{
                sb.append("【"+careOrderItem.getItemName()+"】发药失败\n");
            }
        }
        if(StringUtils.isBlank(sb.toString())){
            return null;
        }else{
            sb.append("原因：库存不足");
            return sb.toString();
        }
    }

    @Override
    public List<CareOrderItem> queryCareOrderItemsByStatus(String coType, String status) {
        QueryWrapper<CareOrderItem> qw = new QueryWrapper<>();
        qw.eq(StringUtils.isNotBlank(coType), CareOrderItem.COL_ITEM_TYPE, coType);
        qw.eq(StringUtils.isNotBlank(status), CareOrderItem.COL_STATUS, status);
        return this.careOrderItemMapper.selectList(qw);
    }

    @Override
    public CareOrder queryCareOrderByCoId(String coId) {
        System.out.println("hihao");
        return this.careOrderMapper.selectById(coId);
    }

}
