package com.qidaiai.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 角色操作类
 * @author qidaiai
 * @date 2021/06/22
 */
@ApiModel(value = "com-qidaiai-domain-RoleDto")
@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto extends BaseDto {

    /**
     * 角色ID
     */
    @ApiModelProperty(value="角色ID")
    private Long roleId;

    /**
     * 角色名称
     */
    @ApiModelProperty(value="角色名称")
    private String roleName;

    /**
     * 角色权限编码
     */
    @ApiModelProperty(value="角色权限编码")
    private String roleCode;

    /**
     * 显示顺序
     */
    @ApiModelProperty(value="显示顺序")
    private Integer roleSort;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String remark;

    /**
     * 角色状态（0正常 1停用）
     */
    @ApiModelProperty(value="角色状态（0正常 1停用）")
    private String status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
}
