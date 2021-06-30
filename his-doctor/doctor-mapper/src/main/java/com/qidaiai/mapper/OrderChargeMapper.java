package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.OrderCharge;

public interface OrderChargeMapper extends BaseMapper {
    /**
     * delete by primary key
     * @param orderId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String orderId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(OrderCharge record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(OrderCharge record);

    /**
     * select by primary key
     * @param orderId primary key
     * @return object by primary key
     */
    OrderCharge selectById(String orderId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(OrderCharge record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(OrderCharge record);
}