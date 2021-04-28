package com.baizitech.auth.controller;

import com.baizitech.auth.service.ValidateCodeService;
import com.baizitech.common.entity.BaizitechResponse;
import com.baizitech.common.exception.BaizitechAuthException;
import com.baizitech.common.exception.ValidateCodeException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@RestController
public class SecurityController {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @Autowired
    private ValidateCodeService validateCodeService;

    @GetMapping("captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException, ValidateCodeException {
        validateCodeService.create(request, response);
    }

    @GetMapping("oauth/test")
    public String testOauth() {
        return "oauth";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @DeleteMapping("signout")
    public BaizitechResponse signout(HttpServletRequest request) throws BaizitechAuthException {
        String authorization = request.getHeader("Authorization");
        String token = StringUtils.replace(authorization, "bearer ", "");
        BaizitechResponse febsResponse = new BaizitechResponse();
        if (!consumerTokenServices.revokeToken(token)) {
            throw new BaizitechAuthException("退出登录失败");
        }
        return febsResponse.message("退出登录成功");
    }
}
