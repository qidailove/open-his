package com.qidaiai.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="com-qidaiai-domain-RegisteredItem")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_registered_item")
public class RegisteredItem {
    /**
    * 挂号项ID
    */
    @ApiModelProperty(value="挂号项ID")
    private Long regItemId;

    /**
    * 挂号项目名称
    */
    @ApiModelProperty(value="挂号项目名称")
    private String regItemName;

    /**
    * 金额
    */
    @ApiModelProperty(value="金额")
    private BigDecimal regItemFee;

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

    /**
    * 状态（0正常 1停用）
    */
    @ApiModelProperty(value="状态（0正常 1停用）")
    private String status;

    public static final String COL_REG_ITEM_ID = "reg_item_id";

    public static final String COL_REG_ITEM_NAME = "reg_item_name";

    public static final String COL_REG_ITEM_FEE = "reg_item_fee";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_STATUS = "status";
}