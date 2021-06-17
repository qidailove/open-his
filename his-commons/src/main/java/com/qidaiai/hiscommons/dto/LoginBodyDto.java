package com.qidaiai.hiscommons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录的数据传输对象
 * @author qidaiai
 * @date 2021/06/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginBodyDto {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String code;

}
