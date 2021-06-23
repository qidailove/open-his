package com.qidaiai.controller.system;

import com.qidaiai.aspectj.annotation.Log;
import com.qidaiai.aspectj.enums.BusinessType;
import com.qidaiai.domain.Dept;
import com.qidaiai.dto.DeptDto;
import com.qidaiai.vo.AjaxResult;
import com.qidaiai.vo.DataGridView;
import com.qidaiai.service.DeptService;
import com.qidaiai.utils.ShiroSecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 部门科室管理控制器
 * @author qidaiai
 * @date 2021/06/22
 */
@RestController
@RequestMapping("system/dept")
@Slf4j
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("listDeptForPage")
    public AjaxResult listDeptForPage(DeptDto deptDto){
        DataGridView gridView = this.deptService.listPage(deptDto);
        return AjaxResult.success("查询成功", gridView.getData(), gridView.getTotal());
    }

    /**
     * 不分页面查询有效的
     */
    @GetMapping("selectAllDept")
    public AjaxResult selectAllDept() {
        List<Dept> lists = this.deptService.list();
        return AjaxResult.success(lists);
    }

    /**
     * 查询一个
     */
    @GetMapping("getDeptById/{deptId}")
    public AjaxResult getDeptById(@PathVariable @Validated @NotEmpty(message = "科室ID为空") Long deptId) {
        Dept dept = this.deptService.getOne(deptId);
        return AjaxResult.success(dept);
    }

    /**
     * 添加
     */
    @PostMapping("addDept")
    @Log(title = "科室管理", businessType = BusinessType.INSERT)
    public AjaxResult addDept(@Validated DeptDto deptDto) {
        deptDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        return AjaxResult.toAjax(this.deptService.addDept(deptDto));
    }

    /**
     * 修改
     */
    @Log(title = "科室管理", businessType = BusinessType.UPDATE)
    @PutMapping("updateDept")
    public AjaxResult updateDept(@Validated DeptDto deptDto) {
        deptDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        return AjaxResult.toAjax(this.deptService.updateDept(deptDto));
    }

    /**
     * 删除
     */
    @Log(title = "科室管理", businessType = BusinessType.DELETE)
    @DeleteMapping("deleteDeptByIds/{deptIds}")
    public AjaxResult delete(@PathVariable @Validated @NotEmpty(message = "科室ID为空") Long[] deptIds) {
        return AjaxResult.toAjax(this.deptService.deleteDeptByIds(deptIds));
    }
}
