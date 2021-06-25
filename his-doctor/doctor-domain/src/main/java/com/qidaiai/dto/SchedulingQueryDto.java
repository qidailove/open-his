package com.qidaiai.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 排班信息表查询对象
 * @author qidaiai
 * @date 2021/06/25
 */
@ApiModel(value="com-bjsxt-dto-SchedulingQueryDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulingQueryDto implements Serializable {

    //用户ID
    private Long userId;
    //部门ID
    private Long deptId;
    //页面传过来的的上一周下一周
    private String queryDate;

    //开始时间
    private String beginDate;
    //结束时间
    private String endDate;

}
