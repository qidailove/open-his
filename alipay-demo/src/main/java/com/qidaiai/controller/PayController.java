package com.qidaiai.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.qidaiai.config.AlipayConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 支付宝回调地址
 * @author qidaiai
 * @date 2021/06/29
 */
@RestController
@RequestMapping("pay")
public class PayController {

    //输出日志
    static Log log = LogFactory.getLog("PayController");

    @RequestMapping("callback/{orderId}")
    public void callback(@PathVariable String orderId, HttpServletRequest request){
        Map<String, String> parameterMap = this.getParameterMap(request);
        String trade_status = parameterMap.get("trade_status");
        try {
            boolean singVerified = AlipaySignature.rsaCheckV1(parameterMap, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
            System.out.println(singVerified);//只有支付宝调用我们系统的接口才能去更新系统订单状态
            System.out.println("验证签名结果:"+singVerified);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            System.out.println("验证签名出现异常");
        }
        //验证是否为支付宝发来的信息
        System.out.println(trade_status);
        System.out.println(parameterMap);
    }

    /**
     * 获取request中的参数集合转Map
     * Map<String,String> parameterMap = RequestUtil.getParameterMap(request)
     * @param request
     * @return
     */
    public Map<String, String> getParameterMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    map.put(paramName, paramValue);
                }
            }
        }
        return map;
    }

}
