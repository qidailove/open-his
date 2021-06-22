package com.qidaiai.service;

import com.qidaiai.domain.OperLog;
import com.qidaiai.dto.OperLogDto;
import com.qidaiai.hiscommons.vo.DataGridView;

/**
 * @author qidaiai
 * @date 2021/06/21
 */
public interface OperLogService{

    /**
     * 插入操作日志
     * @param operLog
     */
    void insertOperLog(OperLog operLog);

    /**
     * 分页查询操作日志
     * @param operLogDto
     * @return
     */
    DataGridView listForPage(OperLogDto operLogDto);

    /**
     * 根据ID删除操作日志
     * @param infoIds
     * @return
     */
    int deleteOperLogByIds(Long[] infoIds);

    /**
     * 清空操作日志
     * @return
     */
    int clearAllOperLog();

}
