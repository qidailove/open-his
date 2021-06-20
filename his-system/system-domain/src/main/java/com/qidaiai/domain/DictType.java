package com.qidaiai.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 字典类型表
    */
@ApiModel(value="com-qidaiai-domain-DictType")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DictType {
    /**
    * 字典主键
    */
    @ApiModelProperty(value="字典主键")
    private Long dictId;

    /**
    * 字典名称
    */
    @ApiModelProperty(value="字典名称")
    private String dictName;

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

    /**
    * 备注
    */
    @ApiModelProperty(value="备注")
    private String remark;
}