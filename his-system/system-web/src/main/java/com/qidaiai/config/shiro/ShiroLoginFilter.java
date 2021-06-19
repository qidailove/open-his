package com.qidaiai.config.shiro;

import com.alibaba.fastjson.JSON;
import com.qidaiai.hiscommons.constants.HttpStatus;
import com.qidaiai.hiscommons.vo.AjaxResult;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShiroLoginFilter extends FormAuthenticationFilter {

    /**
     * 在访问controller前判断是否登录，返回json，不进行重定向。
     * @param request
     * @param response
     * @return true-继续往下执行，false-该filter过滤器已经处理，不继续执行其他过滤器
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json");
        AjaxResult ajaxResult = AjaxResult.fail();
        ajaxResult.put("code", HttpStatus.UNAUTHORIZED);
        ajaxResult.put("msg","登录认证失效，请重新登录！");
        httpServletResponse.getWriter().write(JSON.toJSONString(ajaxResult));

        return false;
    }


}