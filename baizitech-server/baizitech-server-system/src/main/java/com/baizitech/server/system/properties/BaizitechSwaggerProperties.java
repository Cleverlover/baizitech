package com.baizitech.server.system.properties;

import lombok.Data;

/**
 * @author zhengwei.chen
 * @date 2021/4/28 15:52
 */
@Data
public class BaizitechSwaggerProperties {
    private String basePackage;
    private String title;
    private String description;
    private String version;
    private String author;
    private String url;
    private String email;
    private String license;
    private String licenseUrl;
}