package com.qidaiai.hiscommons.dto;

import com.qidaiai.hiscommons.domain.SimpleUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础数据传输类
 * @author qidaiai
 * @date 2021/06/18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDto implements Serializable {

    /**
     * 页码默认为1
     */
    private Integer pageNum = 1;

    /**
     * 每页显示条数 默认10条
     */
    private Integer pageSize = 10;

    /**
     * 当前操作对象
     */
    public SimpleUser simpleUser;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginTime;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

}
