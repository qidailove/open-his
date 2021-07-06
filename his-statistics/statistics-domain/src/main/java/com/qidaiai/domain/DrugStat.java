package com.qidaiai.domain;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@ApiModel(value = "com-qidaiai-domain-DrugStat")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DrugStat extends BaseEntity{

    /**
     * 药品id
     */
    private String medicinesId;

    /**
     * 药品名
     */
    private String medicinesName;

    /**
     * 金额
     */
    private BigDecimal totalAmount;

    /**
     * 销售数量
     */
    private BigDecimal count;

}
