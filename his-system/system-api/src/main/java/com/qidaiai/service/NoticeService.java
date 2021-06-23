package com.qidaiai.service;

import com.qidaiai.dto.NoticeDto;
import com.qidaiai.vo.DataGridView;

/**
 * 公告管理接口
 * @author qidaiai
 * @date 2021/06/23
 */
public interface NoticeService{

    /**
     * 分页查询
     * @param noticeDto
     * @return
     */
    DataGridView listNoticePage(NoticeDto noticeDto);

    /**
     * 根据ID查询
     * @param noticeId
     * @return
     */
    Object getOne(Long noticeId);

    /**
     * 添加
     * @param noticeDto
     * @return
     */
    int addNotice(NoticeDto noticeDto);

    /**
     * 修改
     * @param noticeDto
     * @return
     */
    int updateNotice(NoticeDto noticeDto);

    /**
     * 根据ID删除
     * @param noticeIds
     * @return
     */
    int deleteNoticeByIds(Long[] noticeIds);

}
