package com.baizitech.common.annotation;

import com.baizitech.common.configure.BaizitechServerProtectConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(BaizitechServerProtectConfigure.class)
public @interface EnableBaizitechServerProtect {
}
