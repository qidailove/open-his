package com.qidaiai.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 退费主表
    */
@ApiModel(value="com-qidaiai-domain-OrderBackfee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "his_order_backfee")
public class OrderBackfee extends BaseEntity{
    /**
    * 退费ID
    */
    @ApiModelProperty(value="退费ID")
    private String backId;

    /**
    * 总费用
    */
    @ApiModelProperty(value="总费用")
    private BigDecimal backAmount;

    /**
    * 病历ID
    */
    @ApiModelProperty(value="病历ID")
    private String chId;

    /**
    * 挂号单
    */
    @ApiModelProperty(value="挂号单")
    private String regId;

    /**
    * 患者名称
    */
    @ApiModelProperty(value="患者名称")
    private String patientName;

    /**
    * 订单状态0未退费  1 退费成功 2退费失败  字典表his_backfee_status
    */
    @ApiModelProperty(value="订单状态0未退费  1 退费成功 2退费失败  字典表his_backfee_status")
    private String backStatus;

    /**
    * 退费类型0现金1支付宝  字典表his_pay_type_status
    */
    @ApiModelProperty(value="退费类型0现金1支付宝  字典表his_pay_type_status")
    private String backType;

    /**
    * 关联订单ID his_order_charge  
    */
    @ApiModelProperty(value="关联订单ID his_order_charge  ")
    private String orderId;

    /**
    * 退费交易ID
    */
    @ApiModelProperty(value="退费交易ID")
    private String backPlatformId;

    /**
    * 退费交易时间
    */
    @ApiModelProperty(value="退费交易时间")
    private Date backTime;

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

    public static final String COL_BACK_ID = "back_id";

    public static final String COL_BACK_AMOUNT = "back_amount";

    public static final String COL_CH_ID = "ch_id";

    public static final String COL_REG_ID = "reg_id";

    public static final String COL_PATIENT_NAME = "patient_name";

    public static final String COL_BACK_STATUS = "back_status";

    public static final String COL_BACK_TYPE = "back_type";

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_BACK_PLATFORM_ID = "back_platform_id";

    public static final String COL_BACK_TIME = "back_time";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_UPDATE_BY = "update_by";

}