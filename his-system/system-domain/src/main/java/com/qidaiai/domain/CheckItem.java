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
    * 检查费用表
    */
@ApiModel(value="com-qidaiai-domain-CheckItem")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_check_item")
public class CheckItem extends BaseEntity {
    /**
    * 项目费用ID
    */
    @ApiModelProperty(value="项目费用ID")
    private Long checkItemId;

    /**
    * 项目名称
    */
    @ApiModelProperty(value="项目名称")
    private String checkItemName;

    /**
    * 关键字【查询用】
    */
    @ApiModelProperty(value="关键字【查询用】")
    private String keywords;

    /**
    * 项目单价
    */
    @ApiModelProperty(value="项目单价")
    private BigDecimal unitPrice;

    /**
    * 项目成本
    */
    @ApiModelProperty(value="项目成本")
    private BigDecimal cost;

    /**
    * 单位
    */
    @ApiModelProperty(value="单位")
    private String unit;

    /**
    * 项目类别IDsxt_sys_dict_type
    */
    @ApiModelProperty(value="项目类别IDsxt_sys_dict_type")
    private String typeId;

    /**
    * 状态0正常1停用 sxt_sys_dict_type
    */
    @ApiModelProperty(value="状态0正常1停用 sxt_sys_dict_type")
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

    public static final String COL_CHECK_ITEM_ID = "check_item_id";

    public static final String COL_CHECK_ITEM_NAME = "check_item_name";

    public static final String COL_KEYWORDS = "keywords";

    public static final String COL_UNIT_PRICE = "unit_price";

    public static final String COL_COST = "cost";

    public static final String COL_UNIT = "unit";

    public static final String COL_TYPE_ID = "type_id";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_UPDATE_BY = "update_by";
}