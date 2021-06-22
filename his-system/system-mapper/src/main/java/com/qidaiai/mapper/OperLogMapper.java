package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.OperLog;

public interface OperLogMapper extends BaseMapper {
    /**
     * delete by primary key
     * @param operId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long operId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(OperLog record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(OperLog record);

    /**
     * select by primary key
     * @param operId primary key
     * @return object by primary key
     */
    OperLog selectByPrimaryKey(Long operId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(OperLog record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(OperLog record);
}