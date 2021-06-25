package com.qidaiai.dto;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@ApiModel(value = "com-qidaiai-dto-RegistrationQueryDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RegistrationQueryDto extends BaseDto{

    private Long deptId;

    private String schedulingType;//挂号类型

    private String subsectionType;//挂号时段

    private String schedulingDay;//查询时间
}
