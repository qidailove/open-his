package com.qidaiai.impl;

import com.qidaiai.domain.Workload;
import com.qidaiai.domain.WorkloadStat;
import com.qidaiai.dto.WorkloadQueryDto;
import com.qidaiai.mapper.WorkloadMapper;
import com.qidaiai.service.WorkloadService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class WorkloadServiceImpl implements WorkloadService {

    @Autowired
    private WorkloadMapper workloadMapper;

    @Override
    public List<Workload> queryWorkload(WorkloadQueryDto workloadQueryDto) {
        return this.workloadMapper.queryWorkload(workloadQueryDto);
    }

    public List<WorkloadStat> queryWorkloadStat(WorkloadQueryDto workloadQueryDto) {
        return this.workloadMapper.queryWorkloadStat(workloadQueryDto);
    }

}
