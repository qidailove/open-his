package com.qidaiai.aspectj.annotation;


import com.qidaiai.aspectj.enums.BusinessType;
import com.qidaiai.aspectj.enums.OperatorType;

import java.lang.annotation.*;

/**
 * 自定义日志记录
 * @author qidaiai
 * @date 2021/06/22
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * 模块
     */
    public String title() default "";

    /**
     * 功能
     */
    public BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人类别
     */
    public OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;
}
