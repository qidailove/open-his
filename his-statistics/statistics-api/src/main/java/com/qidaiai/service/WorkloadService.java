package com.qidaiai.service;

import com.qidaiai.domain.Workload;
import com.qidaiai.domain.WorkloadStat;
import com.qidaiai.dto.WorkloadQueryDto;

import java.util.List;

public interface WorkloadService {

    /**
     * 医生工作量统计列表
     * @param workloadQueryDto
     * @return
     */
    List<Workload> queryWorkload(WorkloadQueryDto workloadQueryDto);

    /**
     * 总体工作量统计列表
     * @param workloadQueryDto
     * @return
     */
    List<WorkloadStat> queryWorkloadStat(WorkloadQueryDto workloadQueryDto);

}
