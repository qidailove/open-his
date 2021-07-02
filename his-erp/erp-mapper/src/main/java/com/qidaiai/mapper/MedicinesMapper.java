package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.Medicines;
import org.apache.ibatis.annotations.Param;

public interface MedicinesMapper extends BaseMapper {
    /**
     * delete by primary key
     * @param medicinesId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long medicinesId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Medicines record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Medicines record);

    /**
     * select by primary key
     * @param medicinesId primary key
     * @return object by primary key
     */
    Medicines selectById(Long medicinesId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Medicines record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateById(Medicines record);

    /**
     * 扣减库存
     *
     * @param medicinesId
     * @param num
     * @return
     */
    int deductionMedicinesStorage(@Param("medicinesId") Long medicinesId, @Param("num") Long num);
}