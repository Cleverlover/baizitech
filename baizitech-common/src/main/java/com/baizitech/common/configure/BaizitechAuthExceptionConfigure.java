package com.baizitech.common.configure;

import com.baizitech.common.handler.BaizitechAccessDeniedHandler;
import com.baizitech.common.handler.BaizitechAuthExceptionEntryPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

public class BaizitechAuthExceptionConfigure {

    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public BaizitechAccessDeniedHandler accessDeniedHandler() {
        return new BaizitechAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public BaizitechAuthExceptionEntryPoint authenticationEntryPoint() {
        return new BaizitechAuthExceptionEntryPoint();
    }
}
