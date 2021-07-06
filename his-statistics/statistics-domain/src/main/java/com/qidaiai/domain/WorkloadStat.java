package com.qidaiai.domain;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@ApiModel(value = "com-qidaiai-domain-WorkloadStat")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WorkloadStat extends BaseEntity{

    private String userId;

    private String doctorName;

    private BigDecimal totalAmount;

    private Long count;

}
