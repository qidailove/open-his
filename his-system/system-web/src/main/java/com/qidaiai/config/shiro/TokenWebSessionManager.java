package com.qidaiai.config.shiro;


import com.qidaiai.hiscommons.constants.Constants;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;
import java.util.UUID;

/**
 * 生成toke
 * 如果没有token生成一个返回到前台，
 * 如果有就从请求头里面取出来
 * @Author qidaiai
 * @date 2021/06/18
 */
public class TokenWebSessionManager extends DefaultWebSessionManager {

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        String header = WebUtils.toHttp(request).getHeader(Constants.TOKEN);
        if (StringUtils.hasText(header)){
            return header;
        }
        return UUID.randomUUID().toString();
    }
}
