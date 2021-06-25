package com.qidaiai.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 排班信息表
    */
@ApiModel(value="com-qidaiai-domain-Scheduling")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "his_scheduling")
public class Scheduling extends BaseEntity{
    /**
    * 医生ID
    */
    @ApiModelProperty(value="医生ID")
    private Long userId;

    /**
    * 科室ID
    */
    @ApiModelProperty(value="科室ID")
    private Long deptId;

    /**
    * 值班日期
    */
    @ApiModelProperty(value="值班日期")
    private String schedulingDay;

    /**
    * 排班时段1上午  2下午 3晚上 字典表数据翻译
    */
    @ApiModelProperty(value="排班时段1上午  2下午 3晚上 字典表数据翻译")
    private String subsectionType;

    /**
    * 排班类型1 门诊 2 急诊 字典表数据翻译
    */
    @ApiModelProperty(value="排班类型1 门诊 2 急诊 字典表数据翻译")
    private String schedulingType;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
    * 创建者
    */
    @ApiModelProperty(value="创建者")
    private String createBy;

    public static final String COL_USER_ID = "user_id";

    public static final String COL_DEPT_ID = "dept_id";

    public static final String COL_SCHEDULING_DAY = "scheduling_day";

    public static final String COL_SUBSECTION_TYPE = "subsection_type";

    public static final String COL_SCHEDULING_TYPE = "scheduling_type";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_CREATE_BY = "create_by";
}