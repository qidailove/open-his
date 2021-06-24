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
    * 药品信息表
    */
@ApiModel(value="com-qidaiai-domain-Medicines")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "stock_medicines")
public class Medicines extends BaseEntity{
    @ApiModelProperty(value="")
    private Long medicinesId;

    /**
    * 药品编号
    */
    @ApiModelProperty(value="药品编号")
    private String medicinesNumber;

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
    * 处方价格
    */
    @ApiModelProperty(value="处方价格")
    private BigDecimal prescriptionPrice;

    /**
    * 单位（g/条）
    */
    @ApiModelProperty(value="单位（g/条）")
    private String unit;

    /**
    * 换算量
    */
    @ApiModelProperty(value="换算量")
    private Integer conversion;

    /**
    * 关键字
    */
    @ApiModelProperty(value="关键字")
    private String keywords;

    /**
    * 生产厂家ID
    */
    @ApiModelProperty(value="生产厂家ID")
    private String producterId;

    /**
    * 药品状态0正常0停用 sys_dict_data表 sys_normal_disable
    */
    @ApiModelProperty(value="药品状态0正常0停用 sys_dict_data表 sys_normal_disable")
    private String status;

    /**
    * 库存量
    */
    @ApiModelProperty(value="库存量")
    private Long medicinesStockNum;

    /**
    * 预警值
    */
    @ApiModelProperty(value="预警值")
    private Long medicinesStockDangerNum;

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

    public static final String COL_MEDICINES_ID = "medicines_id";

    public static final String COL_MEDICINES_NUMBER = "medicines_number";

    public static final String COL_MEDICINES_NAME = "medicines_name";

    public static final String COL_MEDICINES_TYPE = "medicines_type";

    public static final String COL_PRESCRIPTION_TYPE = "prescription_type";

    public static final String COL_PRESCRIPTION_PRICE = "prescription_price";

    public static final String COL_UNIT = "unit";

    public static final String COL_CONVERSION = "conversion";

    public static final String COL_KEYWORDS = "keywords";

    public static final String COL_PRODUCTER_ID = "producter_id";

    public static final String COL_STATUS = "status";

    public static final String COL_MEDICINES_STOCK_NUM = "medicines_stock_num";

    public static final String COL_MEDICINES_STOCK_DANGER_NUM = "medicines_stock_danger_num";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_UPDATE_BY = "update_by";

}