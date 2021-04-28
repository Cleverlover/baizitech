package com.baizitech.common.annotation;


import com.baizitech.common.configure.BaizitechAuthExceptionConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(BaizitechAuthExceptionConfigure.class)
public @interface EnableBaizitechAuthExceptionHandler {
}
