package com.qidaiai.mapper;

import com.qidaiai.domain.Check;
import com.qidaiai.domain.CheckStat;
import com.qidaiai.dto.CheckQueryDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckMapper {

    /**
     * 查询检查项列表
     *
     * @param checkQueryDto
     * @return
     */
    List<Check> queryCheck(@Param("check") CheckQueryDto checkQueryDto);

    /**
     * 查询检查项统计列表
     *
     * @param checkQueryDto
     * @return
     */
    List<CheckStat> queryCheckStat(@Param("check") CheckQueryDto checkQueryDto);

}
