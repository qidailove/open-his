package com.qidaiai.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 字典数据表
    */
@ApiModel(value="com-qidaiai-domain-DictData")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DictData {
    /**
    * 字典编码
    */
    @ApiModelProperty(value="字典编码")
    private Long dictCode;

    /**
    * 字典排序
    */
    @ApiModelProperty(value="字典排序")
    private Integer dictSort;

    /**
    * 字典标签
    */
    @ApiModelProperty(value="字典标签")
    private String dictLabel;

    /**
    * 字典键值
    */
    @ApiModelProperty(value="字典键值")
    private String dictValue;

    /**
    * 字典类型
    */
    @ApiModelProperty(value="字典类型")
    private String dictType;

    /**
    * 状态（0正常 1停用）
    */
    @ApiModelProperty(value="状态（0正常 1停用）")
    private String status;

    /**
    * 备注
    */
    @ApiModelProperty(value="备注")
    private String remark;

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

    public static final String COL_DICT_CODE = "dict_code";

    public static final String COL_DICT_SORT = "dict_sort";

    public static final String COL_DICT_LABEL = "dict_label";

    public static final String COL_DICT_VALUE = "dict_value";

    public static final String COL_DICT_TYPE = "dict_type";

    public static final String COL_STATUS = "status";

    public static final String COL_REMARK = "remark";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";
}