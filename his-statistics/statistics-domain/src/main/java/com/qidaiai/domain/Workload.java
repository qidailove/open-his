package com.qidaiai.domain;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "com-qidaiai-domain-Workload")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Workload extends BaseEntity{

    private String regId;

    private String userId;

    private String doctorName;

    private BigDecimal regAmount;

    private String patientName;

    private Date visitDate;

}
