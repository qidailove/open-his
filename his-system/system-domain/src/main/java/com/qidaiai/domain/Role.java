package com.qidaiai.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qidaiai.hiscommons.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 角色信息表
    */
@ApiModel(value="com-qidaiai-domain-Role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_role")
public class Role extends BaseEntity {
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

    public static final String COL_ROLE_ID = "role_id";

    public static final String COL_ROLE_NAME = "role_name";

    public static final String COL_ROLE_CODE = "role_code";

    public static final String COL_ROLE_SORT = "role_sort";

    public static final String COL_REMARK = "remark";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_UPDATE_BY = "update_by";
}