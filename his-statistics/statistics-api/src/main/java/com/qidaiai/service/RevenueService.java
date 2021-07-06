package com.qidaiai.service;

import com.qidaiai.dto.RevenueQueryDto;

import java.util.Map;

public interface RevenueService {

    /**
     * 查询收支统计的数据
     * @param revenueQueryDto
     * @return
     */
    Map<String, Object> queryAllRevenueData(RevenueQueryDto revenueQueryDto);
}
