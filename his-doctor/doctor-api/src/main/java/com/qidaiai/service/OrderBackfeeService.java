package com.qidaiai.service;

import com.qidaiai.domain.OrderBackfeeItem;
import com.qidaiai.dto.OrderBackfeeDto;
import com.qidaiai.dto.OrderBackfeeFormDto;
import com.qidaiai.vo.DataGridView;

import java.util.List;

public interface OrderBackfeeService {

    /**
     * 保存退费单
     * @param orderBackfeeFormDto
     */
    void saveOrderAndItems(OrderBackfeeFormDto orderBackfeeFormDto);

    /**
     * 退费成功之后更改状态
     * @param backId
     * @param o
     * @param payType0
     */
    void backSuccess(String backId, Object o, String payType0);

    /**
     * 分页查询所有退费单
     * @param orderBackfeeDto
     * @return
     */
    DataGridView queryAllOrderBackfeeForPage(OrderBackfeeDto orderBackfeeDto);

    /**
     * 根据退费单的ID查询退费详情信息
     * @param backId
     * @return
     */
    List<OrderBackfeeItem> queryrderBackfeeItemByBackId(String backId);

}
