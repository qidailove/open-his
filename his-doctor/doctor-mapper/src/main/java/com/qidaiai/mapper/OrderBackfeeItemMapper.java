package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.OrderBackfeeItem;

import java.util.List;

public interface OrderBackfeeItemMapper extends BaseMapper {
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
    int insert(OrderBackfeeItem record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(OrderBackfeeItem record);

    /**
     * select by primary key
     * @param itemId primary key
     * @return object by primary key
     */
    OrderBackfeeItem selectByPrimaryKey(String itemId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(OrderBackfeeItem record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(OrderBackfeeItem record);

    List<OrderBackfeeItem> selectById(String backId);
}