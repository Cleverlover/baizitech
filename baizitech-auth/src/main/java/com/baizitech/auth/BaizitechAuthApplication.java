package com.baizitech.auth;

import com.baizitech.common.annotation.BaizitechCloudApplication;
import com.baizitech.common.annotation.EnableBaizitechLettuceRedis;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
//@EnableFebsOauth2FeignClient //开启带令牌的Feign请求，避免微服务内部调用出现401异常
//@EnableBaizitechServerProtect //开启微服务防护，避免客户端绕过网关直接请求微服务
//@EnableBaizitechAuthExceptionHandler //认证类型异常翻译
@EnableBaizitechLettuceRedis
@BaizitechCloudApplication //相当于上面三个
@MapperScan("com.baizitech.auth.mapper")
public class BaizitechAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaizitechAuthApplication.class, args);
    }

}
