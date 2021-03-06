package com.qidaiai.dto;

import com.qidaiai.domain.SimpleUser;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 表单数据提交对象
 * @author qidaiai
 * @date 2021/06/25
 **/
@ApiModel(value="com-qidaiai-dto-SchedulingFormDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulingFormDto implements Serializable {

    private SimpleUser simpleUser;

    private String beginDate;

    private List<SchedulingData> data;

    @Data
    public static class SchedulingData implements  Serializable {
        private Long userId;
        private Long deptId;
        private String subsectionType; //上午 下午  晚上
        //星期的值班值
        private Collection<String> schedulingType;
    }

}
