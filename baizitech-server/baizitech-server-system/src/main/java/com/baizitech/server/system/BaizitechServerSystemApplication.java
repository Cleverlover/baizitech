package com.baizitech.server.system;

import com.baizitech.common.annotation.BaizitechCloudApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author czw
 */
@EnableDiscoveryClient
@SpringBootApplication
@BaizitechCloudApplication
@EnableTransactionManagement
@EnableGlobalMethodSecurity(prePostEnabled = true)
@MapperScan("com.baizitech.server.system.mapper")
public class BaizitechServerSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaizitechServerSystemApplication.class, args);
    }
}
