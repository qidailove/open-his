package com.qidaiai.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.qidaiai.vo.AjaxResult;

@DefaultProperties(defaultFallback = "fallback")
public class BaseController {
    /**
     * 如远程服务不可用，或者出现异常，回调的方法
     * @return
     */
    public AjaxResult fallback(){
        return AjaxResult.toAjax(-1);
    }
}
