package com.qidaiai.service;

import com.qidaiai.domain.User;

public interface UserService{

    /**
     * 根据手机号查询用户
     * @param phone
     * @return
     */
    Object queryUserByPhone(String phone);

    /**
     * 根据用户id查询用户
     * @param userId 用户编号
     * @return
     */
    User getOne(Long userId);

}
