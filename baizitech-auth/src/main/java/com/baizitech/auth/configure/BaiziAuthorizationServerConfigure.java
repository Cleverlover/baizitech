package com.baizitech.auth.configure;

import com.baizitech.auth.properties.BaizitechAuthProperties;
import com.baizitech.auth.properties.BaizitechClientsProperties;
import com.baizitech.auth.service.BaizitechUserDetailServiceImpl;
import com.baizitech.auth.translator.BaizitechWebResponseExceptionTranslator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * 定义一个和认证服务器相关的安全配置类
 */
@Configuration
@EnableAuthorizationServer
public class BaiziAuthorizationServerConfigure extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    @Autowired
    private BaizitechUserDetailServiceImpl userDetailService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private BaizitechAuthProperties authProperties;

    @Autowired
    private BaizitechWebResponseExceptionTranslator exceptionTranslator;

    /**
     * 客户端从认证服务器获取令牌的时候，必须使用client_id为baizitech，client_secret为123456的标识来获取；
     * 该client_id支持password模式获取令牌，并且可以通过refresh_token来获取新的令牌；
     * 在获取client_id为febs的令牌的时候，scope只能指定为all，否则将获取失败；
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        BaizitechClientsProperties[] clientsArray = authProperties.getClients();
        InMemoryClientDetailsServiceBuilder builder = clients.inMemory();
        for (BaizitechClientsProperties client : clientsArray) {
            if (StringUtils.isBlank(client.getClient())) {
                throw new Exception("client不能为空！");
            }
            if (StringUtils.isBlank(client.getSecret())) {
                throw new Exception("secret不能为空！");
            }
            String[] grantTypes = StringUtils.splitByWholeSeparatorPreserveAllTokens(client.getGrantType(), ",");
            builder.withClient(client.getClient())
                    .secret(passwordEncoder.encode(client.getSecret()))
                    .authorizedGrantTypes(grantTypes)
                    .scopes(client.getScope());
        }
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore())
                .userDetailsService(userDetailService)
                .authenticationManager(authenticationManager)
                .tokenServices(defaultTokenServices())
                .exceptionTranslator(exceptionTranslator);
    }

    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Primary
    @Bean
    public DefaultTokenServices defaultTokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore());
        //开启令牌自动刷新
        tokenServices.setSupportRefreshToken(true);
        //令牌有效时间为60 * 60 * 24秒
        tokenServices.setAccessTokenValiditySeconds(authProperties.getAccessTokenValiditySeconds());
        //刷新令牌有效时间为60 * 60 * 24 * 7秒
        tokenServices.setRefreshTokenValiditySeconds(authProperties.getRefreshTokenValiditySeconds());
        return tokenServices;
    }

}
