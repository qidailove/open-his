package com.qidaiai.controller.erp;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qidaiai.controller.BaseController;
import com.qidaiai.dto.InventoryLogDto;
import com.qidaiai.service.impl.InventoryLogService;
import com.qidaiai.vo.AjaxResult;
import com.qidaiai.vo.DataGridView;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 入库记录管理控制器
 * @author qidaiai
 * @date 2021/06/25
 */
@RestController
@RequestMapping("erp/inventoryLog")
public class InventoryLogController extends BaseController {

    @Reference
    private InventoryLogService inventoryLogService;

    /**
     * 分页查询
     */
    @GetMapping("listInventoryLogForPage")
    @HystrixCommand
    public AjaxResult listMedicinesForPage(InventoryLogDto inventoryLogDto){
        DataGridView gridView = this.inventoryLogService.listInventoryLogPage(inventoryLogDto);
        return AjaxResult.success("查询成功",gridView.getData(),gridView.getTotal());
    }
}
