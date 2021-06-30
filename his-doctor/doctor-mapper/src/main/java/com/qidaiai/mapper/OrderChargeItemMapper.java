package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.OrderChargeItem;

import java.util.List;

public interface OrderChargeItemMapper extends BaseMapper {
    /**
     * delete by primary key
     * @param itemId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String itemId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(OrderChargeItem record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(OrderChargeItem record);

    /**
     * select by primary key
     * @param itemId primary key
     * @return object by primary key
     */
    OrderChargeItem selectByPrimaryKey(String itemId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(OrderChargeItem record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(OrderChargeItem record);


    List<OrderChargeItem> selectListBySql(String orderId);
}