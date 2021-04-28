package com.baizitech.common.handler;

import com.baizitech.common.entity.BaizitechResponse;
import com.baizitech.common.exception.BaizitechAuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
public class BaseExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaizitechResponse handleException(Exception e) {
        log.error("系统内部异常，异常信息", e);
        return new BaizitechResponse().message("系统内部异常");
    }

    @ExceptionHandler(value = BaizitechAuthException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaizitechResponse handleFebsAuthException(BaizitechAuthException e) {
        log.error("系统错误", e);
        return new BaizitechResponse().message(e.getMessage());
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public BaizitechResponse handleAccessDeniedException() {
        return new BaizitechResponse().message("没有权限访问该资源");
    }
}
