package com.qidaiai.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 患者信息表
    */
@ApiModel(value="com-qidaiai-domain-Patient")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "his_patient")
public class Patient extends BaseEntity{
    /**
    * 主键
    */
    @ApiModelProperty(value="主键")
    private String patientId;

    /**
    * 患者姓名
    */
    @ApiModelProperty(value="患者姓名")
    private String name;

    /**
    * 患者电话
    */
    @ApiModelProperty(value="患者电话")
    private String phone;

    /**
    * 患者性别0男1女 2未知字典表 sys_user_sex
    */
    @ApiModelProperty(value="患者性别0男1女 2未知字典表 sys_user_sex")
    private String sex;

    /**
    * 出生年月
    */
    @ApiModelProperty(value="出生年月")
    private String birthday;

    /**
    * 身份证号[认证ID]
    */
    @ApiModelProperty(value="身份证号[认证ID]")
    private String idCard;

    /**
    * 地址信息
    */
    @ApiModelProperty(value="地址信息")
    private String address;

    /**
    * 过敏信息
    */
    @ApiModelProperty(value="过敏信息")
    private String allergyInfo;

    /**
    * 是否完善信息，0未完善1已完善 字典表 his_patient_msg_final
    */
    @ApiModelProperty(value="是否完善信息，0未完善1已完善 字典表 his_patient_msg_final")
    private String isFinal;

    /**
    * 登录密码
    */
    @ApiModelProperty(value="登录密码")
    @JsonIgnore
    private String password;

    /**
    * 微信openid
    */
    @ApiModelProperty(value="微信openid")
    @JsonIgnore
    private String openid;

    /**
    * 最后登录ip
    */
    @ApiModelProperty(value="最后登录ip")
    private String lastLoginIp;

    /**
    * 最后登录时间
    */
    @ApiModelProperty(value="最后登录时间")
    private Date lastLoginTime;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
    * 更新时间
    */
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    public static final String COL_PATIENT_ID = "patient_id";

    public static final String COL_NAME = "name";

    public static final String COL_PHONE = "phone";

    public static final String COL_SEX = "sex";

    public static final String COL_BIRTHDAY = "birthday";

    public static final String COL_ID_CARD = "id_card";

    public static final String COL_ADDRESS = "address";

    public static final String COL_ALLERGY_INFO = "allergy_info";

    public static final String COL_IS_FINAL = "is_final";

    public static final String COL_PASSWORD = "password";

    public static final String COL_OPENID = "openid";

    public static final String COL_LAST_LOGIN_IP = "last_login_ip";

    public static final String COL_LAST_LOGIN_TIME = "last_login_time";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

}