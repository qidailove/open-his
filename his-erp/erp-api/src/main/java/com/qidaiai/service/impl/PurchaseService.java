package com.qidaiai.service.impl;

import com.qidaiai.domain.Purchase;
import com.qidaiai.domain.PurchaseItem;
import com.qidaiai.domain.SimpleUser;
import com.qidaiai.dto.PurchaseDto;
import com.qidaiai.dto.PurchaseFormDto;
import com.qidaiai.vo.DataGridView;

import java.util.List;

public interface PurchaseService{

    /**
     * 分页查询
     * @param purchaseDto
     * @return
     */
    DataGridView listPurchasePage(PurchaseDto purchaseDto);

    /**
     * 根据采购单据号查询单据信息
     * @param purchaseId
     * @return
     */
    Purchase getPurchaseById(String purchaseId);

    /**
     * 提交 审核
     * @param purchaseId
     * @return
     */
    int doAudit(String purchaseId, SimpleUser simpleUser);

    /**
     * 作废
     * @param purchaseId
     * @return
     */
    int doInvalid(String purchaseId);

    /**
     * 审核通过
     * @param purchaseId
     * @return
     */
    int auditPass(String purchaseId);

    /**
     * 审核不通过
     * @param purchaseId
     * @return
     */
    int auditNoPass(String purchaseId,String auditMsg);

    /**
     * 根据ID查询一个采购信息详情
     * @param purchaseId
     * @return
     */
    List<PurchaseItem> getPurchaseItemById(String purchaseId);

    /**
     * 暂存采购单数据和详情
     * @param purchaseFormDto
     * @return
     */
    int addPurchaseAndItem(PurchaseFormDto purchaseFormDto);

    /**
     * 保存并提交审核采购单数据和详情
     * @param purchaseFormDto
     * @return
     */
    int addPurchaseAndItemToAudit(PurchaseFormDto purchaseFormDto);

    /**
     * 保存并提交审核采购单数据和详情
     * @param purchaseId
     * @param currentSimpleUser
     * @return
     */
    int doInventory(String purchaseId, SimpleUser currentSimpleUser);

}
