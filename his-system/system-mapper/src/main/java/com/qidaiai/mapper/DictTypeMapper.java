package com.qidaiai.mapper;

import com.qidaiai.domain.DictType;

public interface DictTypeMapper {
    /**
     * delete by primary key
     * @param dictId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long dictId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(DictType record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(DictType record);

    /**
     * select by primary key
     * @param dictId primary key
     * @return object by primary key
     */
    DictType selectByPrimaryKey(Long dictId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(DictType record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(DictType record);
}