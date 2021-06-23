package com.qidaiai.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 系统访问记录
    */
@ApiModel(value="com-qidaiai-domain-LoginInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo extends BaseEntity {
    /**
    * 访问ID
    */
    @ApiModelProperty(value="访问ID")
    private Long infoId;

    /**
    * 用户名称
    */
    @ApiModelProperty(value="用户名称")
    private String userName;

    /**
    * 登陆账号
    */
    @ApiModelProperty(value="登陆账号")
    private String loginAccount;

    /**
    * 登录IP地址
    */
    @ApiModelProperty(value="登录IP地址")
    private String ipAddr;

    /**
    * 登录地点
    */
    @ApiModelProperty(value="登录地点")
    private String loginLocation;

    /**
    * 浏览器类型
    */
    @ApiModelProperty(value="浏览器类型")
    private String browser;

    /**
    * 操作系统
    */
    @ApiModelProperty(value="操作系统")
    private String os;

    /**
    * 登录状态（0成功 1失败）字典表
    */
    @ApiModelProperty(value="登录状态（0成功 1失败）字典表")
    private String loginStatus;

    /**
    * 登陆类型0系统用户1患者用户 字典表
    */
    @ApiModelProperty(value="登陆类型0系统用户1患者用户 字典表")
    private String loginType;

    /**
    * 提示消息
    */
    @ApiModelProperty(value="提示消息")
    private String msg;

    /**
    * 访问时间
    */
    @ApiModelProperty(value="访问时间")
    private Date loginTime;

    public static final String COL_INFO_ID = "info_id";

    public static final String COL_USER_NAME = "user_name";

    public static final String COL_LOGIN_ACCOUNT = "login_account";

    public static final String COL_IP_ADDR = "ip_addr";

    public static final String COL_LOGIN_LOCATION = "login_location";

    public static final String COL_BROWSER = "browser";

    public static final String COL_OS = "os";

    public static final String COL_LOGIN_STATUS = "login_status";

    public static final String COL_LOGIN_TYPE = "login_type";

    public static final String COL_MSG = "msg";

    public static final String COL_LOGIN_TIME = "login_time";
}