package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.Registration;

public interface RegistrationMapper extends BaseMapper {
    /**
     * delete by primary key
     * @param regId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String regId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Registration record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Registration record);

    /**
     * select by primary key
     * @param regId primary key
     * @return object by primary key
     */
    Registration selectById(String regId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Registration record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Registration record);
}