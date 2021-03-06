package com.qidaiai.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qidaiai.constants.Constants;
import com.qidaiai.domain.*;
import com.qidaiai.dto.PurchaseDto;
import com.qidaiai.dto.PurchaseFormDto;
import com.qidaiai.dto.PurchaseItemDto;
import com.qidaiai.mapper.InventoryLogMapper;
import com.qidaiai.mapper.MedicinesMapper;
import com.qidaiai.mapper.PurchaseItemMapper;
import com.qidaiai.mapper.PurchaseMapper;
import com.qidaiai.utils.IdGeneratorSnowflake;
import com.qidaiai.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService{

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Autowired
    private PurchaseItemMapper purchaseItemMapper;

    @Autowired
    private InventoryLogMapper inventoryLogMapper;

    @Autowired
    private MedicinesMapper medicinesMapper;


    @Override
    public DataGridView listPurchasePage(PurchaseDto purchaseDto) {
        Page<Purchase> page=new Page<>(purchaseDto.getPageNum(),purchaseDto.getPageSize());
        QueryWrapper<Purchase> qw=new QueryWrapper<>();
        qw.eq(StringUtils.isNotBlank(purchaseDto.getProviderId()),Purchase.COL_PROVIDER_ID,purchaseDto.getProviderId());
        qw.eq(StringUtils.isNotBlank(purchaseDto.getStatus()),Purchase.COL_STATUS,purchaseDto.getStatus());
        qw.like(StringUtils.isNotBlank(purchaseDto.getApplyUserName()),Purchase.COL_APPLY_USER_NAME,purchaseDto.getApplyUserName());
        qw.orderByDesc(Purchase.COL_CREATE_TIME);
        this.purchaseMapper.selectPage(page,qw);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    @Override
    public Purchase getPurchaseById(String purchaseId) {
        return this.purchaseMapper.selectById(purchaseId);
    }

    @Override
    public int doAudit(String purchaseId, SimpleUser simpleUser) {
        Purchase purchase = this.purchaseMapper.selectById(purchaseId);
        purchase.setStatus(Constants.STOCK_PURCHASE_STATUS_2);//????????????????????????
        purchase.setApplyUserName(simpleUser.getUserName());
        purchase.setApplyUserId(Long.valueOf(simpleUser.getUserId().toString()));
        return this.purchaseMapper.updateById(purchase);
    }

    @Override
    public int doInvalid(String purchaseId) {
        Purchase purchase = this.purchaseMapper.selectById(purchaseId);
        purchase.setStatus(Constants.STOCK_PURCHASE_STATUS_5);//?????????????????????
        return this.purchaseMapper.updateById(purchase);
    }

    @Override
    public int auditPass(String purchaseId) {
        Purchase purchase = this.purchaseMapper.selectById(purchaseId);
        purchase.setStatus(Constants.STOCK_PURCHASE_STATUS_3);//???????????????????????????
        return this.purchaseMapper.updateById(purchase);
    }

    @Override
    public int auditNoPass(String purchaseId, String auditMsg) {
        Purchase purchase = this.purchaseMapper.selectById(purchaseId);
        purchase.setStatus(Constants.STOCK_PURCHASE_STATUS_4);//??????????????????????????????
        purchase.setAuditMsg(auditMsg);
        return this.purchaseMapper.updateById(purchase);
    }

    @Override
    public List<PurchaseItem> getPurchaseItemById(String purchaseId) {
        if(null!=purchaseId){
            QueryWrapper<PurchaseItem> qw=new QueryWrapper<>();
            qw.eq(PurchaseItem.COL_PURCHASE_ID,purchaseId);
            return purchaseItemMapper.selectList(qw);
        }
        return Collections.EMPTY_LIST;
    }


    /**
     * ??????   ?????????????????????Constants.STOCK_PURCHASE_STATUS_1
     * @param purchaseFormDto
     * @return
     */
    @Override
    public int addPurchaseAndItem(PurchaseFormDto purchaseFormDto) {
        Purchase purchase = this.purchaseMapper.selectById(purchaseFormDto.getPurchaseDto().getPurchaseId());
        if(null!=purchase){
            //?????????????????????
            this.purchaseMapper.deleteById(purchase.getPurchaseId());
            //???????????????????????????
            QueryWrapper<PurchaseItem> qw=new QueryWrapper<>();
            qw.eq(PurchaseItem.COL_PURCHASE_ID,purchase.getPurchaseId());
            this.purchaseItemMapper.delete(qw);
        }
        //???????????????????????????
        Purchase newPurchase=new Purchase();
        BeanUtil.copyProperties(purchaseFormDto.getPurchaseDto(),newPurchase);
        newPurchase.setStatus(Constants.STOCK_PURCHASE_STATUS_1);//???????????????
        newPurchase.setCreateBy(purchaseFormDto.getPurchaseDto().getSimpleUser().getUserName());
        newPurchase.setCreateTime(DateUtil.date());
        int a=this.purchaseMapper.insert(newPurchase);
        //??????????????????
        for (PurchaseItemDto item : purchaseFormDto.getPurchaseItemDtos()) {
            PurchaseItem purchaseItem=new PurchaseItem();
            BeanUtil.copyProperties(item,purchaseItem);
            purchaseItem.setPurchaseId(newPurchase.getPurchaseId());
            purchaseItem.setItemId(IdGeneratorSnowflake.snowflakeId().toString());
            this.purchaseItemMapper.insert(purchaseItem);
        }
        return a;
    }

    /**
     * ?????????????????????  ???????????????Constants.STOCK_PURCHASE_STATUS_2
     * @param purchaseFormDto
     * @return
     */
    @Override
    public int addPurchaseAndItemToAudit(PurchaseFormDto purchaseFormDto) {
        Purchase purchase = this.purchaseMapper.selectById(purchaseFormDto.getPurchaseDto().getPurchaseId());
        if(null!=purchase){
            //?????????????????????
            this.purchaseMapper.deleteById(purchase.getPurchaseId());
            //???????????????????????????
            QueryWrapper<PurchaseItem> qw=new QueryWrapper<>();
            qw.eq(PurchaseItem.COL_PURCHASE_ID,purchase.getPurchaseId());
            this.purchaseItemMapper.delete(qw);
        }
        //???????????????????????????
        Purchase newPurchase=new Purchase();
        BeanUtil.copyProperties(purchaseFormDto.getPurchaseDto(),newPurchase);
        newPurchase.setStatus(Constants.STOCK_PURCHASE_STATUS_2);//?????????
        newPurchase.setCreateBy(purchaseFormDto.getPurchaseDto().getSimpleUser().getUserName());
        newPurchase.setCreateTime(DateUtil.date());
        //??????????????????????????????ID
        newPurchase.setApplyUserId(Long.valueOf(purchaseFormDto.getPurchaseDto().getSimpleUser().getUserId().toString()));
        newPurchase.setApplyUserName(purchaseFormDto.getPurchaseDto().getSimpleUser().getUserName());
        int a=this.purchaseMapper.insert(newPurchase);
        //??????????????????
        for (PurchaseItemDto item : purchaseFormDto.getPurchaseItemDtos()) {
            PurchaseItem purchaseItem=new PurchaseItem();
            BeanUtil.copyProperties(item,purchaseItem);
            purchaseItem.setPurchaseId(newPurchase.getPurchaseId());
            purchaseItem.setItemId(IdGeneratorSnowflake.snowflakeId().toString());
            this.purchaseItemMapper.insert(purchaseItem);
        }
        return a;
    }

    /**
     * ??????
     * ??????
     * ???stock_inventory_log????????????????????? ?????????stock_medicines?????????
     * @param purchaseId
     * @param currentSimpleUser
     * @return
     */
    @Override
    public int doInventory(String purchaseId, SimpleUser currentSimpleUser) {
        Purchase purchase = this.purchaseMapper.selectById(purchaseId);
        if(null!=purchase||purchase.getStatus().equals(Constants.STOCK_PURCHASE_STATUS_3)){
            //????????????
            QueryWrapper<PurchaseItem> qw=new QueryWrapper<>();
            qw.eq(PurchaseItem.COL_PURCHASE_ID,purchase.getPurchaseId());
            List<PurchaseItem> purchaseItems = this.purchaseItemMapper.selectList(qw);
            for (PurchaseItem purchaseItem : purchaseItems) {
                InventoryLog inventoryLog=new InventoryLog();
                inventoryLog.setInventoryLogId(purchaseItem.getItemId());
                inventoryLog.setPurchaseId(purchaseItem.getPurchaseId());
                inventoryLog.setMedicinesId(purchaseItem.getMedicinesId());
                inventoryLog.setInventoryLogNum(purchaseItem.getPurchaseNumber());
                inventoryLog.setTradePrice(purchaseItem.getTradePrice());
                inventoryLog.setTradeTotalAmount(purchaseItem.getTradeTotalAmount());
                inventoryLog.setBatchNumber(purchaseItem.getBatchNumber());
                inventoryLog.setMedicinesName(purchaseItem.getMedicinesName());
                inventoryLog.setMedicinesType(purchaseItem.getMedicinesType());
                inventoryLog.setPrescriptionType(purchaseItem.getPrescriptionType());
                inventoryLog.setProducterId(purchaseItem.getProducterId());
                inventoryLog.setConversion(purchaseItem.getConversion());
                inventoryLog.setUnit(purchaseItem.getUnit());
                inventoryLog.setCreateTime(DateUtil.date());
                inventoryLog.setCreateBy(currentSimpleUser.getUserName());
                //????????????
                inventoryLogMapper.insert(inventoryLog);

                //??????????????????
                Medicines medicines=this.medicinesMapper.selectById(Long.parseLong(purchaseItem.getMedicinesId()));
                medicines.setMedicinesStockNum(medicines.getMedicinesStockNum()+purchaseItem.getPurchaseNumber());
                medicines.setUpdateBy(currentSimpleUser.getUserName());
                this.medicinesMapper.updateById(medicines);
            }
            //????????????  ????????????????????????????????????
            purchase.setStatus(Constants.STOCK_PURCHASE_STATUS_6);//????????????
            purchase.setStorageOptTime(DateUtil.date());
            purchase.setStorageOptUser(currentSimpleUser.getUserName());
            return this.purchaseMapper.updateById(purchase);
        }
        return -1;
    }

}
