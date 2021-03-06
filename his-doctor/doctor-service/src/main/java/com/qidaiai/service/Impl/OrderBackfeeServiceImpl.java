package com.qidaiai.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qidaiai.constants.Constants;
import com.qidaiai.domain.CareOrderItem;
import com.qidaiai.domain.OrderBackfee;
import com.qidaiai.domain.OrderBackfeeItem;
import com.qidaiai.domain.OrderChargeItem;
import com.qidaiai.dto.OrderBackfeeDto;
import com.qidaiai.dto.OrderBackfeeFormDto;
import com.qidaiai.dto.OrderBackfeeItemDto;
import com.qidaiai.mapper.*;
import com.qidaiai.service.OrderBackfeeService;
import com.qidaiai.vo.DataGridView;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service(methods = {@Method(name = "saveOrderAndItems",retries = 1),@Method(name = "backSuccess",retries = 1)})
public class OrderBackfeeServiceImpl implements OrderBackfeeService {

    @Autowired
    private OrderBackfeeMapper orderBackfeeMapper;

    @Autowired
    private OrderBackfeeItemMapper orderBackfeeItemMapper;

    @Autowired
    private OrderChargeMapper orderChargeMapper;

    @Autowired
    private OrderChargeItemMapper orderChargeItemMapper;

    @Autowired
    private CareOrderItemMapper careOrderItemMapper;

    @Override
    public void saveOrderAndItems(OrderBackfeeFormDto orderBackfeeFormDto) {
        OrderBackfeeDto orderBackfeeDto = orderBackfeeFormDto.getOrderBackfeeDto();
        List<OrderBackfeeItemDto> orderBackfeeItemDtoList = orderBackfeeFormDto.getOrderBackfeeItemDtoList();

        OrderBackfee orderBackfee=new OrderBackfee();
        BeanUtil.copyProperties(orderBackfeeDto,orderBackfee);
        orderBackfee.setBackStatus(Constants.ORDER_STATUS_0);
        orderBackfee.setCreateTime(DateUtil.date());
        orderBackfee.setCreateBy(orderBackfeeFormDto.getSimpleUser().getUserName());
        int i=this.orderBackfeeMapper.insert(orderBackfee);
        //????????????
        for (OrderBackfeeItemDto orderBackfeeItemDto : orderBackfeeItemDtoList) {
            OrderBackfeeItem orderBackfeeItem=new OrderBackfeeItem();
            BeanUtil.copyProperties(orderBackfeeItemDto,orderBackfeeItem);
            //????????????????????????ID
            orderBackfeeItem.setBackId(orderBackfeeDto.getBackId());
            orderBackfeeItem.setStatus(Constants.ORDER_DETAILS_STATUS_0);
            this.orderBackfeeItemMapper.insert(orderBackfeeItem);
        }
    }

    @Override
    public void backSuccess(String backId, Object backPlatformId, String backType) {
        //??????????????????ID??????????????????
        OrderBackfee orderBackfee = this.orderBackfeeMapper.selectById(backId);
        //????????????????????????
        orderBackfee.setBackPlatformId((String) backPlatformId);
        //??????????????????
        orderBackfee.setBackType(backType);
        //??????????????????
        orderBackfee.setBackTime(DateUtil.date());
        //??????????????????
        orderBackfee.setBackStatus(Constants.ORDER_BACKFEE_STATUS_1);//?????????
        //??????????????????
        this.orderBackfeeMapper.updateById(orderBackfee);
        //?????????????????????????????????????????????
        QueryWrapper<OrderBackfeeItem> qw=new QueryWrapper<>();
        qw.eq(OrderBackfeeItem.COL_BACK_ID,backId);
        List<OrderBackfeeItem> orderBackfeeItems = this.orderBackfeeItemMapper.selectList(qw);
        List<String> allItemIds=new ArrayList<>();
        for (OrderBackfeeItem orderBackfeeItem : orderBackfeeItems) {
            allItemIds.add(orderBackfeeItem.getItemId());
        }
        //??????????????????????????????
        OrderBackfeeItem orderBackItemObj=new OrderBackfeeItem();
        orderBackItemObj.setStatus(Constants.ORDER_DETAILS_STATUS_2);//?????????
        QueryWrapper<OrderBackfeeItem> orderBackItemQw=new QueryWrapper<>();
        orderBackItemQw.in(OrderBackfeeItem.COL_ITEM_ID,allItemIds);
        this.orderBackfeeItemMapper.update(orderBackItemObj,orderBackItemQw);

        //???????????????????????????
        OrderChargeItem orderItemObj=new OrderChargeItem();
        orderItemObj.setStatus(Constants.ORDER_DETAILS_STATUS_2);//?????????
        QueryWrapper<OrderChargeItem> orderItemQw=new QueryWrapper<>();
        orderItemQw.in(OrderChargeItem.COL_ITEM_ID,allItemIds);
        this.orderChargeItemMapper.update(orderItemObj,orderItemQw);

        //???????????????????????????
        CareOrderItem careItemObj=new CareOrderItem();
        careItemObj.setStatus(Constants.ORDER_DETAILS_STATUS_2);//?????????
        QueryWrapper<CareOrderItem> careItemQw=new QueryWrapper<>();
        careItemQw.in(CareOrderItem.COL_ITEM_ID,allItemIds);
        this.careOrderItemMapper.update(careItemObj,careItemQw);
    }

    @Override
    public DataGridView queryAllOrderBackfeeForPage(OrderBackfeeDto orderBackfeeDto) {
        Page<OrderBackfee> page=new Page<>(orderBackfeeDto.getPageNum(),orderBackfeeDto.getPageSize());
        QueryWrapper<OrderBackfee> qw=new QueryWrapper<>();
        qw.like(StringUtils.isNotBlank(orderBackfeeDto.getPatientName()),OrderBackfee.COL_PATIENT_NAME,orderBackfeeDto.getPatientName());
        qw.like(StringUtils.isNotBlank(orderBackfeeDto.getRegId()),OrderBackfee.COL_REG_ID,orderBackfeeDto.getRegId());
        qw.orderByDesc(OrderBackfee.COL_CREATE_TIME);
        this.orderBackfeeMapper.selectPage(page,qw);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    @Override
    public List<OrderBackfeeItem> queryrderBackfeeItemByBackId(String backId) {
        return this.orderBackfeeItemMapper.selectById(backId);
    }
}
