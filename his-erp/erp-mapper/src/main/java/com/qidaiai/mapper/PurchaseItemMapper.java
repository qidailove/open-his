package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.PurchaseItem;

public interface PurchaseItemMapper extends BaseMapper {
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
    int insert(PurchaseItem record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(PurchaseItem record);

    /**
     * select by primary key
     * @param itemId primary key
     * @return object by primary key
     */
    PurchaseItem selectById(String itemId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PurchaseItem record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PurchaseItem record);
}