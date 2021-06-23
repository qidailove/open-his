package com.qidaiai.service;

import com.qidaiai.domain.LoginInfo;
import com.qidaiai.dto.LoginInfoDto;
import com.qidaiai.vo.DataGridView;

public interface LoginInfoService{

    /**
     * 添加
     *
     * @param loginInfo
     * @return
     */
    int insertLoginInfo(LoginInfo loginInfo);

    /**
     * 分页查询
     *
     * @param loginInfoDto
     * @return
     */
    DataGridView listForPage(LoginInfoDto loginInfoDto);

    /**
     * 删除登陆日志
     *
     * @param infoIds
     * @return
     */
    int deleteLoginInfoByIds(Long[] infoIds);

    /**
     * 清空登陆日志
     *
     * @return
     */
    int clearLoginInfo();

}
