package com.qidaiai.hiscommons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

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
    @NotNull(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotNull(message = "用户密码不能为空")
    private String password;

    /**
     * 验证码
     */
    private String code;

}
