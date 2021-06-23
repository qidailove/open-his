package com.qidaiai.dto;

import com.qidaiai.hiscommons.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ApiModel(value = "com-qidaiai-domain-CheckItemDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CheckItemDto extends BaseDto {

    /**
     * 项目费用ID
     */
    @ApiModelProperty(value="项目费用ID")
    private Long checkItemId;

    /**
     * 项目名称
     */
    @NotBlank(message = "项目名称不能为空")
    @ApiModelProperty(value="项目名称")
    private String checkItemName;

    /**
     * 关键字【查询用】
     */
    @NotBlank(message = "关键字不能为空")
    @ApiModelProperty(value="关键字【查询用】")
    private String keywords;

    /**
     * 项目单价
     */
    @NotNull(message = "项目单价不能为空")
    @ApiModelProperty(value="项目单价")
    private BigDecimal unitPrice;

    /**
     * 项目成本
     */
    @NotNull(message = "项目成本不能为空")
    @ApiModelProperty(value="项目成本")
    private BigDecimal cost;

    /**
     * 单位
     */
    @NotBlank(message = "项目单位不能为空")
    @ApiModelProperty(value="单位")
    private String unit;

    /**
     * 项目类别IDsxt_sys_dict_type
     */
    @NotBlank(message = "项目类别不能为空")
    @ApiModelProperty(value="项目类别IDsxt_sys_dict_type")
    private String typeId;

    /**
     * 状态0正常1停用 sxt_sys_dict_type
     */
    @NotBlank(message = "项目状态不能为空")
    @ApiModelProperty(value="状态0正常1停用 sxt_sys_dict_type")
    private String status;
}
