package com.baizitech.server.system.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author zhengwei.chen
 * @date 2021/4/28 15:54
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:baizitech-server-system.properties"})
@ConfigurationProperties(prefix = "baizitech.server.system")
public class BaizitechServerSystemProperties {

    /**
     * 免认证 URI，多个值的话以逗号分隔
     */
    private String anonUrl;

    private BaizitechSwaggerProperties swagger = new BaizitechSwaggerProperties();
}