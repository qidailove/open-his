package com.qidaiai.mapper;

import com.qidaiai.domain.InventoryLog;

public interface InventoryLogMapper {
    /**
     * delete by primary key
     * @param inventoryLogId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String inventoryLogId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(InventoryLog record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(InventoryLog record);

    /**
     * select by primary key
     * @param inventoryLogId primary key
     * @return object by primary key
     */
    InventoryLog selectByPrimaryKey(String inventoryLogId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(InventoryLog record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(InventoryLog record);
}