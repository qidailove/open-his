package com.qidaiai.controller.statistics;

import cn.hutool.core.date.DateUtil;
import com.qidaiai.controller.BaseController;
import com.qidaiai.domain.Workload;
import com.qidaiai.domain.WorkloadStat;
import com.qidaiai.dto.WorkloadQueryDto;
import com.qidaiai.service.WorkloadService;
import com.qidaiai.vo.AjaxResult;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 工作量统计控制器
 * @author qidaiai
 * @date 2021/07/06
 */
@RestController
@RequestMapping("statistics/workload")
public class StatWorkloadController extends BaseController {

    @Reference
    private WorkloadService workloadService;

    /**
     * 医生工作量统计列表
     */
    @GetMapping("queryWorkload")
    public AjaxResult queryWorkload(WorkloadQueryDto workloadQueryDto){
        if(workloadQueryDto.getBeginTime()==null){
            workloadQueryDto.setQueryDate(DateUtil.format(DateUtil.date(),"yyyy-MM-dd"));
        }
        List<Workload> workloadList=this.workloadService.queryWorkload(workloadQueryDto);
        return AjaxResult.success(workloadList);
    }


    /**
     * 总体工作量统计列表
     */
    @GetMapping("queryWorkloadStat")
    public AjaxResult queryWorkloadStat(WorkloadQueryDto workloadQueryDto){
        if(workloadQueryDto.getBeginTime()==null){
            workloadQueryDto.setQueryDate(DateUtil.format(DateUtil.date(),"yyyy-MM-dd"));
        }
        List<WorkloadStat> workloadList=this.workloadService.queryWorkloadStat(workloadQueryDto);
        return AjaxResult.success(workloadList);
    }

}
