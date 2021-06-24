package com.qidaiai.controller.erp;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qidaiai.aspectj.annotation.Log;
import com.qidaiai.aspectj.enums.BusinessType;
import com.qidaiai.controller.BaseController;
import com.qidaiai.dto.MedicinesDto;
import com.qidaiai.service.impl.MedicinesService;
import com.qidaiai.utils.ShiroSecurityUtils;
import com.qidaiai.vo.AjaxResult;
import com.qidaiai.vo.DataGridView;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 药品信息管理控制器
 * @author qidaiai
 * @date 2021/06/24
 */
@RestController
@RequestMapping("erp/medicines")
public class MedicinesController extends BaseController {

    @Reference//使用dubbo的引用
    private MedicinesService medicinesService;

    /**
     * 分页查询
     */
    @GetMapping("listMedicinesForPage")
    @HystrixCommand
    public AjaxResult listMedicinesForPage(MedicinesDto medicinesDto){
        DataGridView gridView = this.medicinesService.listMedicinesPage(medicinesDto);
        return AjaxResult.success("查询成功",gridView.getData(),gridView.getTotal());
    }
    /**
     * 添加
     */
    @PostMapping("addMedicines")
    @HystrixCommand
    @Log(title = "添加药品信息",businessType = BusinessType.INSERT)
    public AjaxResult addMedicines(@Validated MedicinesDto medicinesDto) {
        medicinesDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        return AjaxResult.toAjax(this.medicinesService.addMedicines(medicinesDto));
    }

    /**
     * 修改
     */
    @PutMapping("updateMedicines")
    @HystrixCommand
    @Log(title = "修改药品信息",businessType = BusinessType.UPDATE)
    public AjaxResult updateMedicines(@Validated MedicinesDto medicinesDto) {
        medicinesDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        return AjaxResult.toAjax(this.medicinesService.updateMedicines(medicinesDto));
    }


    /**
     * 根据ID查询一个药品信息信息
     */
    @GetMapping("getMedicinesById/{medicinesId}")
    @HystrixCommand
    public AjaxResult getMedicinesById(@PathVariable @Validated @NotNull(message = "药品信息ID不能为空") Long medicinesId) {
        return AjaxResult.success(this.medicinesService.getOne(medicinesId));
    }

    /**
     * 删除
     */
    @DeleteMapping("deleteMedicinesByIds/{medicinesIds}")
    @HystrixCommand
    @Log(title = "删除药品信息",businessType = BusinessType.DELETE)
    public AjaxResult deleteMedicinesByIds(@PathVariable @Validated @NotEmpty(message = "要删除的ID不能为空") Long[] medicinesIds) {
        return AjaxResult.toAjax(this.medicinesService.deleteMedicinesByIds(medicinesIds));
    }

    /**
     * 查询所有可用的药品信息
     */
    @HystrixCommand
    @GetMapping("selectAllMedicines")
    public AjaxResult selectAllMedicines() {
        return AjaxResult.success(this.medicinesService.selectAllMedicines());
    }

    /**
     * 调整库存
     */
    @HystrixCommand
    @Log(title = "调整药品库存信息",businessType = BusinessType.UPDATE)
    @PostMapping("updateMedicinesStorage/{medicinesId}/{medicinesStockNum}")
    public AjaxResult xx(@PathVariable Long medicinesId,@PathVariable Long medicinesStockNum){
        int i = this.medicinesService.updateMedicinesStorage(medicinesId, medicinesStockNum);
        return AjaxResult.toAjax(i);
    }
}
