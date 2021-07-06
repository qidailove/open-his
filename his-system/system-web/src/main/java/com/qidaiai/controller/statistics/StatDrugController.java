package com.qidaiai.controller.statistics;

import cn.hutool.core.date.DateUtil;
import com.qidaiai.domain.Drug;
import com.qidaiai.domain.DrugStat;
import com.qidaiai.dto.DrugQueryDto;
import com.qidaiai.service.DrugService;
import com.qidaiai.vo.AjaxResult;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 发药数量统计管理控制器
 * @author qidaiai
 * @date 2021/07/06
 */
@RestController
@RequestMapping("statistics/drug")
public class StatDrugController {

    @Reference
    private DrugService drugService;

    /**
     * 查询发药统计列表
     */
    @GetMapping("queryDrug")
    public AjaxResult queryDrug(DrugQueryDto drugQueryDto){
        if(drugQueryDto.getBeginTime()==null){
            drugQueryDto.setQueryDate(DateUtil.format(DateUtil.date(),"yyyy-MM-dd"));
        }
        List<Drug> drugList=this.drugService.queryDrug(drugQueryDto);
        return AjaxResult.success(drugList);
    }


    /**
     * 查询发药数量统计列表
     */
    @GetMapping("queryDrugStat")
    public AjaxResult queryDrugStat(DrugQueryDto drugQueryDto){
        if(drugQueryDto.getBeginTime()==null){
            drugQueryDto.setQueryDate(DateUtil.format(DateUtil.date(),"yyyy-MM-dd"));
        }
        List<DrugStat> drugList=this.drugService.queryDrugStat(drugQueryDto);
        return AjaxResult.success(drugList);
    }

}
