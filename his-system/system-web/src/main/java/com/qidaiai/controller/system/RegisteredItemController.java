package com.qidaiai.controller.system;

import com.qidaiai.aspectj.annotation.Log;
import com.qidaiai.aspectj.enums.BusinessType;
import com.qidaiai.domain.RegisteredItem;
import com.qidaiai.dto.RegisteredItemDto;
import com.qidaiai.vo.AjaxResult;
import com.qidaiai.vo.DataGridView;
import com.qidaiai.service.RegisteredItemService;
import com.qidaiai.utils.ShiroSecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 挂号管理控制器
 * @author qidaiai
 * @date 2021/06/23
 */
@RestController
@RequestMapping("system/registeredItem")
public class RegisteredItemController {

    @Autowired
    private RegisteredItemService registeredItemService;

    /**
     * 分页查询
     */
    @GetMapping("listRegisteredItemForPage")
    public AjaxResult listRegisteredItemForPage(RegisteredItemDto registeredItemDto){
        DataGridView gridView = this.registeredItemService.listRegisteredItemPage(registeredItemDto);
        return AjaxResult.success("查询成功",gridView.getData(),gridView.getTotal());
    }
    /**
     * 添加
     */
    @PostMapping("addRegisteredItem")
    @Log(title = "添加挂号项目",businessType = BusinessType.INSERT)
    public AjaxResult addRegisteredItem(@Validated RegisteredItemDto registeredItemDto) {
        registeredItemDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        return AjaxResult.toAjax(this.registeredItemService.addRegisteredItem(registeredItemDto));
    }

    /**
     * 修改
     */
    @PutMapping("updateRegisteredItem")
    @Log(title = "修改挂号项目",businessType = BusinessType.UPDATE)
    public AjaxResult updateRegisteredItem(@Validated RegisteredItemDto registeredItemDto) {
        registeredItemDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        return AjaxResult.toAjax(this.registeredItemService.updateRegisteredItem(registeredItemDto));
    }


    /**
     * 根据ID查询一个挂号项目信息
     */
    @GetMapping("getRegisteredItemById/{registeredItemId}")
    public AjaxResult getRegisteredItemById(@PathVariable @Validated @NotNull(message = "挂号项目ID不能为空") Long registeredItemId) {
        return AjaxResult.success(this.registeredItemService.getOne(registeredItemId));
    }

    /**
     * 删除
     */
    @DeleteMapping("deleteRegisteredItemByIds/{registeredItemIds}")
    @Log(title = "删除挂号项目",businessType = BusinessType.DELETE)
    public AjaxResult deleteRegisteredItemByIds(@PathVariable @Validated @NotEmpty(message = "要删除的ID不能为空") Long[] registeredItemIds) {
        return AjaxResult.toAjax(this.registeredItemService.deleteRegisteredItemByIds(registeredItemIds));
    }

    /**
     * 查询所有可用的挂号项目
     */
    @GetMapping("selectAllRegisteredItem")
    public AjaxResult selectAllRegisteredItem(){
        List<RegisteredItem> checkItems=this.registeredItemService.queryAllRegisteredItems();
        return AjaxResult.success(checkItems);
    }
}
