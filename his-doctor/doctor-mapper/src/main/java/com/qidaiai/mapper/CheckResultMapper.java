package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.CheckResult;

public interface CheckResultMapper extends BaseMapper {
    /**
     * delete by primary key
     * @param cocId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String cocId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(CheckResult record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(CheckResult record);

    /**
     * select by primary key
     * @param cocId primary key
     * @return object by primary key
     */
    CheckResult selectByPrimaryKey(String cocId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CheckResult record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CheckResult record);
}