package com.baizitech.server.system;

import com.baizitech.common.annotation.BaizitechCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableDiscoveryClient
@SpringBootApplication
//@EnableFebsOauth2FeignClient //开启带令牌的Feign请求，避免微服务内部调用出现401异常
//@EnableBaizitechServerProtect //开启微服务防护，避免客户端绕过网关直接请求微服务
//@EnableBaizitechAuthExceptionHandler //认证类型异常翻译
@BaizitechCloudApplication //相当于上面三个
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BaizitechServerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaizitechServerSystemApplication.class, args);
    }

}
