package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.Purchase;

public interface PurchaseMapper extends BaseMapper {
    /**
     * delete by primary key
     * @param purchaseId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String purchaseId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Purchase record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Purchase record);

    /**
     * select by primary key
     * @param purchaseId primary key
     * @return object by primary key
     */
    Purchase selectById(String purchaseId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Purchase record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateById(Purchase record);
}