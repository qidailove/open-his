package com.qidaiai.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 退费订单详情表
    */
@ApiModel(value="com-qidaiai-domain-OrderBackfeeItem")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "his_order_charge_item")
public class OrderBackfeeItem extends BaseEntity{
    /**
    * 详情ID和his_care_order_*表里面的ID一样
    */
    @ApiModelProperty(value="详情ID和his_care_order_*表里面的ID一样")
    private String itemId;

    /**
    * 处方ID【备用】
    */
    @ApiModelProperty(value="处方ID【备用】")
    private String coId;

    /**
    * 项目名称
    */
    @ApiModelProperty(value="项目名称")
    private String itemName;

    /**
    * 项目价格
    */
    @ApiModelProperty(value="项目价格")
    private BigDecimal itemPrice;

    /**
    * 项目数量
    */
    @ApiModelProperty(value="项目数量")
    private Long itemNum;

    /**
    * 小计
    */
    @ApiModelProperty(value="小计")
    private Long itemAmount;

    /**
    * 订单ID his_oder_backfee主键
    */
    @ApiModelProperty(value="订单ID his_oder_backfee主键")
    private String backId;

    /**
    * 项目类型0药品  还是1检查项
    */
    @ApiModelProperty(value="项目类型0药品  还是1检查项")
    private String itemType;

    /**
    * 状态，0未支付，1已支付，2，已退费  3，已完成   字典表 his_order_details_status
    */
    @ApiModelProperty(value="状态，0未支付，1已支付，2，已退费  3，已完成   字典表 his_order_details_status")
    private String status;

    public static final String COL_ITEM_ID = "item_id";

    public static final String COL_CO_ID = "co_id";

    public static final String COL_ITEM_NAME = "item_name";

    public static final String COL_ITEM_PRICE = "item_price";

    public static final String COL_ITEM_NUM = "item_num";

    public static final String COL_ITEM_AMOUNT = "item_amount";

    public static final String COL_BACK_ID = "back_id";

    public static final String COL_ITEM_TYPE = "item_type";

    public static final String COL_STATUS = "status";

}