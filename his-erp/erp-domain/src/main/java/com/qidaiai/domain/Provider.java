package com.qidaiai.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 供应商信息表
    */
@ApiModel(value="com-qidaiai-domain-Provider")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "stock_provider")
public class Provider extends BaseEntity{
    /**
    * 供应商id
    */
    @ApiModelProperty(value="供应商id")
    private Long providerId;

    /**
    * 供应商名称
    */
    @ApiModelProperty(value="供应商名称")
    private String providerName;

    /**
    * 联系人名称
    */
    @ApiModelProperty(value="联系人名称")
    private String contactName;

    /**
    * 联系人手机
    */
    @ApiModelProperty(value="联系人手机")
    private String contactMobile;

    /**
    * 联系人电话
    */
    @ApiModelProperty(value="联系人电话")
    private String contactTel;

    /**
    * 银行账号
    */
    @ApiModelProperty(value="银行账号")
    private String bankAccount;

    /**
    * 供应商地址
    */
    @ApiModelProperty(value="供应商地址")
    private String providerAddress;

    /**
    * 状态（0正常 1停用）sys_normal_disable
    */
    @ApiModelProperty(value="状态（0正常 1停用）sys_normal_disable")
    private String status;

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

    /**
    * 创建者
    */
    @ApiModelProperty(value="创建者")
    private String createBy;

    /**
    * 更新者
    */
    @ApiModelProperty(value="更新者")
    private String updateBy;

    public static final String COL_PROVIDER_ID = "provider_id";

    public static final String COL_PROVIDER_NAME = "provider_name";

    public static final String COL_CONTACT_NAME = "contact_name";

    public static final String COL_CONTACT_MOBILE = "contact_mobile";

    public static final String COL_CONTACT_TEL = "contact_tel";

    public static final String COL_BANK_ACCOUNT = "bank_account";

    public static final String COL_PROVIDER_ADDRESS = "provider_address";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_UPDATE_BY = "update_by";
}