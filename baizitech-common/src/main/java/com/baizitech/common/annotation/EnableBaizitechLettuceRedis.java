package com.baizitech.common.annotation;

import com.baizitech.common.configure.BaizitechLettuceRedisConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(BaizitechLettuceRedisConfigure.class)
public @interface EnableBaizitechLettuceRedis {
}
