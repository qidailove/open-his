package com.qidaiai;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author qidaiai
 * @date 2021/06/18
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.qidaiai.mapper"})
@EnableDubbo
@EnableHystrix
@EnableCircuitBreaker
public class SystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class,args);
        System.out.println("主系统启动成功");
    }
}
