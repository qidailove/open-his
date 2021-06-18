package com.qidaiai.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息表
 */
@ApiModel(value = "com-qidaiai-domain-User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Long userId;

    /**
     * 部门ID
     */
    @ApiModelProperty(value = "部门ID")
    private Long deptId;

    /**
     * 用户账号
     */
    @ApiModelProperty(value = "用户账号")
    private String userName;

    /**
     * 用户类型（0超级用户为 1为系统用户）
     */
    @ApiModelProperty(value = "用户类型（0超级用户为 1为系统用户）")
    private String userType;

    /**
     * 用户性别（0男 1女 2未知）
     */
    @ApiModelProperty(value = "用户性别（0男 1女 2未知）")
    private String sex;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String picture;

    /**
     * 学历 sys_dict_type:sys_user_background
     */
    @ApiModelProperty(value = "学历 sys_dict_type:sys_user_background")
    private String background;

    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    private String phone;

    /**
     * 用户邮箱
     */
    @ApiModelProperty(value = "用户邮箱")
    private String email;

    /**
     * 擅长
     */
    @ApiModelProperty(value = "擅长")
    private String strong;

    /**
     * 荣誉
     */
    @ApiModelProperty(value = "荣誉")
    private String honor;

    /**
     * 简介
     */
    @ApiModelProperty(value = "简介")
    private String introduction;

    /**
     * 医生级别sys_dict_type:sys_user_level
     */
    @ApiModelProperty(value = ",医生级别sys_dict_type:sys_user_level")
    private String userRank;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 最后一次登录时间
     */
    @ApiModelProperty(value = "最后一次登录时间")
    private Date lastLoginTime;

    /**
     * 最后登陆IP
     */
    @ApiModelProperty(value = "最后登陆IP")
    private String lastLoginIp;

    /**
     * 帐号状态（0正常 1停用）
     */
    @ApiModelProperty(value = "帐号状态（0正常 1停用）")
    private String status;

    @ApiModelProperty(value = "")
    private String unionId;

    /**
     * 用户授权登录openid 扩展第三方登陆使用
     */
    @ApiModelProperty(value = "用户授权登录openid 扩展第三方登陆使用")
    private String openId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")
    private String createBy;

    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者")
    private String updateBy;

    /**
     * 盐
     */
    @ApiModelProperty(value = "盐")
    private String salt;

    /**
     * 是否需要参与排班0需要,1 不需要
     */
    @ApiModelProperty(value = "是否需要参与排班0需要,1 不需要")
    private String schedulingFlag;

    public static final String COL_USER_ID = "user_id";

    public static final String COL_DEPT_ID = "dept_id";

    public static final String COL_USER_NAME = "user_name";

    public static final String COL_USER_TYPE = "user_type";

    public static final String COL_SEX = "sex";

    public static final String COL_AGE = "age";

    public static final String COL_PICTURE = "picture";

    public static final String COL_BACKGROUND = "background";

    public static final String COL_PHONE = "phone";

    public static final String COL_EMAIL = "email";

    public static final String COL_STRONG = "strong";

    public static final String COL_HONOR = "honor";

    public static final String COL_INTRODUCTION = "introduction";

    public static final String COL_USER_RANK = "user_rank";

    public static final String COL_PASSWORD = "password";

    public static final String COL_LAST_LOGIN_TIME = "last_login_time";

    public static final String COL_LAST_LOGIN_IP = "last_login_ip";

    public static final String COL_STATUS = "status";

    public static final String COL_UNION_ID = "union_id";

    public static final String COL_OPEN_ID = "open_id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_SALT = "salt";

    public static final String COL_SCHEDULING_FLAG = "scheduling_flag";
}