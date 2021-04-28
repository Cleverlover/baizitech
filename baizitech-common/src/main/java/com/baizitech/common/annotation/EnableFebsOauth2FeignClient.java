package com.baizitech.common.annotation;

import com.baizitech.common.configure.BaizitechOAuth2FeignConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(BaizitechOAuth2FeignConfigure.class)
public @interface EnableFebsOauth2FeignClient {
}
