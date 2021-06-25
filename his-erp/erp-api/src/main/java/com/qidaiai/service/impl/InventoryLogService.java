package com.qidaiai.service.impl;

import com.qidaiai.dto.InventoryLogDto;
import com.qidaiai.vo.DataGridView;

public interface InventoryLogService {

    /**
     * 分页查询
     *
     * @param inventoryLogDto
     * @return
     */
    DataGridView listInventoryLogPage(InventoryLogDto inventoryLogDto);
}
