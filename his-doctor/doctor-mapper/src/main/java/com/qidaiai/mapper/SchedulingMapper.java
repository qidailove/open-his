package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.Scheduling;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SchedulingMapper extends BaseMapper {
    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Scheduling record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Scheduling record);

    /**
     * @param deptId
     * @param schedulingDay
     * @param schedulingType
     * @param subsectionType
     * @return
     */
    List<Long> queryHasSchedulingDeptIds(@Param("deptId") Long deptId, @Param("schedulingDay") String schedulingDay, @Param("schedulingType") String schedulingType, @Param("subsectionType") String subsectionType);


    void deleteBySql(@Param(value = "userId") Long userId, @Param(value = "deptId") Long deptId, @Param(value = "beginDate") String beginDate, @Param(value = "endDate") String endDate);
}