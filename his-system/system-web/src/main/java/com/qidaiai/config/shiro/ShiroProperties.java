package com.qidaiai.config.shiro;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * shiro自定义配置参数
 * @author qidaiai
 * @date 2021/06/18
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "shiro")
public class ShiroProperties {

    /**
     * 密码加密方式
     */
    private String hashAlgorithmName = "md5";

    /**
     * 密码散列次数
     */
    private Integer hashIterations = 2;

    /**
     * 不拦击的路径的数组
     */
    private String[] anonUrls;

    /**
     * 拦击的路径的数组
     */
    private String[] authcUrls;


}
