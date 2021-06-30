package com.qidaiai.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@ApiModel(value = "com-qidaiai-dto-OrderChargeFromDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderChargeFromDto extends BaseDto{

    //主订单
    private OrderChargeDto orderChargeDto;

    //订单详情
    @NotEmpty(message = "订单详情不能为空")
    private List<OrderChargeItemDto> orderChargeItemDtoList;

}
