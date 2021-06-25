package com.qidaiai.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="com-qidaiai-domain-Purchase")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "stock_purchase")
public class Purchase extends BaseEntity{
    /**
    * 制单号ID 全局ID雪花算法
    */
    @ApiModelProperty(value="制单号ID 全局ID雪花算法")
    private String purchaseId;

    /**
    * 供应商ID
    */
    @ApiModelProperty(value="供应商ID")
    private String providerId;

    /**
    * 采购批发总额
    */
    @ApiModelProperty(value="采购批发总额")
    private BigDecimal purchaseTradeTotalAmount;

    /**
    * 单据状态； 1未提交2待审核 3审核通过 4审核失败 5作废 6入库成功 字典表 his_order_status
    */
    @ApiModelProperty(value="单据状态； 1未提交2待审核 3审核通过 4审核失败 5作废 6入库成功 字典表 his_order_status")
    private String status;

    /**
    * 申请人ID
    */
    @ApiModelProperty(value="申请人ID")
    private Long applyUserId;

    /**
    * 申请人名称
    */
    @ApiModelProperty(value="申请人名称")
    private String applyUserName;

    /**
    * 入库操作人
    */
    @ApiModelProperty(value="入库操作人")
    private String storageOptUser;

    /**
    * 入库操作时间
    */
    @ApiModelProperty(value="入库操作时间")
    private Date storageOptTime;

    /**
    * 审核信息
    */
    @ApiModelProperty(value="审核信息")
    private String auditMsg;

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

    public static final String COL_PURCHASE_ID = "purchase_id";

    public static final String COL_PROVIDER_ID = "provider_id";

    public static final String COL_PURCHASE_TRADE_TOTAL_AMOUNT = "purchase_trade_total_amount";

    public static final String COL_STATUS = "status";

    public static final String COL_APPLY_USER_ID = "apply_user_id";

    public static final String COL_APPLY_USER_NAME = "apply_user_name";

    public static final String COL_STORAGE_OPT_USER = "storage_opt_user";

    public static final String COL_STORAGE_OPT_TIME = "storage_opt_time";

    public static final String COL_AUDIT_MSG = "audit_msg";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_UPDATE_BY = "update_by";
}