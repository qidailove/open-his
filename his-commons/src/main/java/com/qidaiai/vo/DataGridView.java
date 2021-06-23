package com.qidaiai.vo;

import com.qidaiai.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 表格数据传输类
 * @author qidaiai
 * @date 2021/06/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "com-qidaiai-vo-DataGridView")
public class DataGridView extends BaseDto {

    private Long total;

    private List<?> data;
}
