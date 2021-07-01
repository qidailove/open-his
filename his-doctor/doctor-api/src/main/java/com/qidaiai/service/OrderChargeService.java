package com.qidaiai.service;

import com.qidaiai.domain.OrderCharge;
import com.qidaiai.domain.OrderChargeItem;
import com.qidaiai.dto.OrderChargeDto;
import com.qidaiai.dto.OrderChargeFromDto;
import com.qidaiai.vo.DataGridView;

import java.util.List;

public interface OrderChargeService {

    /**
     * 保存收费订单及详情
     * @param orderChargeFromDto
     */
    void saveOrderAndItems(OrderChargeFromDto orderChargeFromDto);

    /**
     * 支付成功之后更新订单状态
     * @param orderId
     * @param payPlatformId 平台交易ID 如果是现金，则为空
     */
    void paySuccess(String orderId, String payPlatformId, String payType);

    /**
     * 根据订单ID查询订单信息
     * @param orderId
     * @return
     */
    OrderCharge queryOrderChargeByOrderId(String orderId);

    /**
     * 分页查询所有收费单
     * @param orderChargeDto
     * @return
     */
    DataGridView queryAllOrderChargeForPage(OrderChargeDto orderChargeDto);

    /**
     * 据收费单的ID查询收费详情信息
     * @param orderId
     * @return
     */
    List<OrderChargeItem> queryOrderChargeItemByOrderId(String orderId);

}
