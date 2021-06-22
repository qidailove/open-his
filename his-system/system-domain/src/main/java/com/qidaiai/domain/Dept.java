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
    * 部门/科室表
    */
@ApiModel(value="com-qidaiai-domain-Dept")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_dept")
public class Dept extends BaseEntity {
    /**
    * 部门科室id
    */
    @ApiModelProperty(value="部门科室id")
    private Long deptId;

    /**
    * 部门名称
    */
    @ApiModelProperty(value="部门名称")
    private String deptName;

    /**
    * 挂号编号
    */
    @ApiModelProperty(value="挂号编号")
    private Integer regNumber;

    /**
    * 科室编号
    */
    @ApiModelProperty(value="科室编号")
    private String deptNumber;

    /**
    * 显示顺序
    */
    @ApiModelProperty(value="显示顺序")
    private Integer orderNum;

    /**
    * 负责人
    */
    @ApiModelProperty(value="负责人")
    private String deptLeader;

    /**
    * 联系电话
    */
    @ApiModelProperty(value="联系电话")
    private String leaderPhone;

    /**
    * 部门状态（0正常 1停用）
    */
    @ApiModelProperty(value="部门状态（0正常 1停用）")
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

    public static final String COL_DEPT_ID = "dept_id";

    public static final String COL_DEPT_NAME = "dept_name";

    public static final String COL_REG_NUMBER = "reg_number";

    public static final String COL_DEPT_NUMBER = "dept_number";

    public static final String COL_ORDER_NUM = "order_num";

    public static final String COL_DEPT_LEADER = "dept_leader";

    public static final String COL_LEADER_PHONE = "leader_phone";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_UPDATE_BY = "update_by";
}