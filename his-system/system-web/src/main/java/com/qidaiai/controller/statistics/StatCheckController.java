package com.qidaiai.controller.statistics;


import cn.hutool.core.date.DateUtil;
import com.qidaiai.controller.BaseController;
import com.qidaiai.dto.CheckQueryDto;
import com.qidaiai.service.CheckService;
import com.qidaiai.vo.AjaxResult;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 检查项目统计控制器
 * @author qidaiai
 * @date 2021/07/06
 */
@RestController
@RequestMapping("statistics/check")
public class StatCheckController extends BaseController {

    @Reference
    private CheckService checkService;

    /**
     * 查询检查项目列表
     */
    @GetMapping("queryCheck")
    public AjaxResult queryCheck(CheckQueryDto checkQueryDto){
        if(checkQueryDto.getBeginTime()==null){
            checkQueryDto.setQueryDate(DateUtil.format(DateUtil.date(),"yyyy-MM-dd"));
        }
        return AjaxResult.success(this.checkService.queryCheck(checkQueryDto));
    }

}
