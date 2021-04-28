package com.baizitech.common.selector;

import com.baizitech.common.configure.BaizitechAuthExceptionConfigure;
import com.baizitech.common.configure.BaizitechOAuth2FeignConfigure;
import com.baizitech.common.configure.BaizitechServerProtectConfigure;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author czw
 * 集成@EnableFebsOauth2FeignClient（开启带令牌的Feign请求，避免微服务内部调用出现401异常）、
 * @EnableBaizitechServerProtect（开启微服务防护，避免客户端绕过网关直接请求微服务）、
 * @EnableBaizitechAuthExceptionHandler（认证类型异常翻译） 三个注解
 */
public class BaizitechCloudApplicationSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                BaizitechAuthExceptionConfigure.class.getName(),
                BaizitechOAuth2FeignConfigure.class.getName(),
                BaizitechServerProtectConfigure.class.getName()
        };
    }
}
