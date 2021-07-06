package com.qidaiai.domain;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@ApiModel(value = "com-qidaiai-domain-CheckStat")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CheckStat extends BaseEntity{

    /**
     * 检查项目ID
     */
    private Long checkItemId;

    /**
     * 检查项目名称
     */
    private String checkItemName;

    /**
     * 项目总价
     */
    private BigDecimal totalAmount;

    /**
     * 检查次数
     */
    private Integer count;

}
