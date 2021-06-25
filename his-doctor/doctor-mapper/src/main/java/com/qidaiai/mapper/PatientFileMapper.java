package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.PatientFile;

public interface PatientFileMapper extends BaseMapper {
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
    int insert(PatientFile record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(PatientFile record);

    /**
     * select by primary key
     * @param patientId primary key
     * @return object by primary key
     */
    PatientFile selectByPrimaryKey(String patientId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PatientFile record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PatientFile record);
}