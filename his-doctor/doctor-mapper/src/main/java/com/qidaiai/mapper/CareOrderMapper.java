package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.CareOrder;

public interface CareOrderMapper extends BaseMapper {
    /**
     * delete by primary key
     * @param coId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String coId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(CareOrder record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(CareOrder record);

    /**
     * select by primary key
     * @param coId primary key
     * @return object by primary key
     */
    CareOrder selectById(String coId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CareOrder record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CareOrder record);
}