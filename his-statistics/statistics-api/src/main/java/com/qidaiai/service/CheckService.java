package com.qidaiai.service;

import com.qidaiai.domain.Check;
import com.qidaiai.domain.CheckStat;
import com.qidaiai.dto.CheckQueryDto;

import java.util.List;

public interface CheckService {

    /**
     * 查询检查项列表
     * @param checkQueryDto
     * @return
     */
    List<Check> queryCheck(CheckQueryDto checkQueryDto);

    /**
     * 查询检查项统计列表
     * @param checkQueryDto
     * @return
     */
    List<CheckStat> queryCheckStat(CheckQueryDto checkQueryDto);

}
