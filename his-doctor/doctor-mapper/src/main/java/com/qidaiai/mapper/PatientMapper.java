package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.Patient;

public interface PatientMapper extends BaseMapper {
    /**
     * delete by primary key
     * @param patientId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String patientId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Patient record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Patient record);

    /**
     * select by primary key
     * @param patientId primary key
     * @return object by primary key
     */
    Patient selectById(String patientId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Patient record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Patient record);
}