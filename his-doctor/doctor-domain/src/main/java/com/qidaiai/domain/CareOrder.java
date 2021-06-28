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
    * 药用处方表
    */
@ApiModel(value="com-qidaiai-domain-CareOrder")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "his_care_order")
public class CareOrder extends BaseEntity{
    /**
    * 处方ID
    */
    @ApiModelProperty(value="处方ID")
    private String coId;

    /**
    * 处方类型0药用处方1检查处方
    */
    @ApiModelProperty(value="处方类型0药用处方1检查处方")
    private String coType;

    /**
    * 医生id
    */
    @ApiModelProperty(value="医生id")
    private Long userId;

    /**
    * 患者id
    */
    @ApiModelProperty(value="患者id")
    private String patientId;

    /**
    * 患者姓名
    */
    @ApiModelProperty(value="患者姓名")
    private String patientName;

    /**
    * 关联病历id
    */
    @ApiModelProperty(value="关联病历id")
    private String chId;

    /**
    * 处方全额
    */
    @ApiModelProperty(value="处方全额")
    private BigDecimal allAmount;

    /**
    * 创建者
    */
    @ApiModelProperty(value="创建者")
    private String createBy;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
    * 更新者
    */
    @ApiModelProperty(value="更新者")
    private String updateBy;

    /**
    * 更新时间
    */
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    public static final String COL_CO_ID = "co_id";

    public static final String COL_CO_TYPE = "co_type";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_PATIENT_ID = "patient_id";

    public static final String COL_PATIENT_NAME = "patient_name";

    public static final String COL_CH_ID = "ch_id";

    public static final String COL_ALL_AMOUNT = "all_amount";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";

}