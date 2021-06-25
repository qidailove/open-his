package com.qidaiai.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="com-qidaiai-domain-PurchaseItem")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "stock_purchase_item")
public class PurchaseItem extends BaseEntity{
    /**
    * 详情ID
    */
    @ApiModelProperty(value="详情ID")
    private String itemId;

    /**
    * 采购单据ID
    */
    @ApiModelProperty(value="采购单据ID")
    private String purchaseId;

    /**
    * 采购数量
    */
    @ApiModelProperty(value="采购数量")
    private Integer purchaseNumber;

    /**
    * 批发价
    */
    @ApiModelProperty(value="批发价")
    private BigDecimal tradePrice;

    /**
    * 批发额
    */
    @ApiModelProperty(value="批发额")
    private BigDecimal tradeTotalAmount;

    /**
    * 药品生产批次号
    */
    @ApiModelProperty(value="药品生产批次号")
    private String batchNumber;

    /**
    * 备注
    */
    @ApiModelProperty(value="备注")
    private String remark;

    /**
    * 药品ID
    */
    @ApiModelProperty(value="药品ID")
    private String medicinesId;

    /**
    * 药品名称
    */
    @ApiModelProperty(value="药品名称")
    private String medicinesName;

    /**
    * 药品分类 sys_dict_data表his_medicines_type
    */
    @ApiModelProperty(value="药品分类 sys_dict_data表his_medicines_type")
    private String medicinesType;

    /**
    * 处方类型 sys_dict_data表his_prescription_type
    */
    @ApiModelProperty(value="处方类型 sys_dict_data表his_prescription_type")
    private String prescriptionType;

    /**
    * 生产厂家ID
    */
    @ApiModelProperty(value="生产厂家ID")
    private String producterId;

    /**
    * 换算量
    */
    @ApiModelProperty(value="换算量")
    private Integer conversion;

    /**
    * 单位（g/条）
    */
    @ApiModelProperty(value="单位（g/条）")
    private String unit;

    /**
    * 关键字
    */
    @ApiModelProperty(value="关键字")
    private String keywords;

    public static final String COL_ITEM_ID = "item_id";

    public static final String COL_PURCHASE_ID = "purchase_id";

    public static final String COL_PURCHASE_NUMBER = "purchase_number";

    public static final String COL_TRADE_PRICE = "trade_price";

    public static final String COL_TRADE_TOTAL_AMOUNT = "trade_total_amount";

    public static final String COL_BATCH_NUMBER = "batch_number";

    public static final String COL_REMARK = "remark";

    public static final String COL_MEDICINES_ID = "medicines_id";

    public static final String COL_MEDICINES_NAME = "medicines_name";

    public static final String COL_MEDICINES_TYPE = "medicines_type";

    public static final String COL_PRESCRIPTION_TYPE = "prescription_type";

    public static final String COL_PRODUCTER_ID = "producter_id";

    public static final String COL_CONVERSION = "conversion";

    public static final String COL_UNIT = "unit";

    public static final String COL_KEYWORDS = "keywords";
}