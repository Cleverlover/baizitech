package com.baizitech.common.annotation;

import com.baizitech.common.selector.BaizitechCloudApplicationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(BaizitechCloudApplicationSelector.class)
public @interface BaizitechCloudApplication {
}
