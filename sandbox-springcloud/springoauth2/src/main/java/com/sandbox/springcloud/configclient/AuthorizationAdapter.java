package com.sandbox.springcloud.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Configuration
public class AuthorizationAdapter extends AuthorizationServerConfigurerAdapter {
    /**
     * 注入authenticationManager
     * 来支持 password grant type
     */
    @Autowired
    private AuthenticationManager authenticationManager;

//    public AuthorizationAdapter() {
//        super();
//    }

//    @Autowired
//    public AuthorizationAdapter(ApplicationContext applicationContext) {
//        super();
//        dataSource = applicationContext.getBean(DataSource.class);
//    }

    @Autowired
    private DataSource dataSource;

//    @Autowired
//    private void setDataSource(ApplicationContext applicationContext) {
//        this.dataSource = applicationContext.getBean(DataSource.class);
//        //this.dataSource = dataSource;
//    }

//    @Autowired
//    DataSourceProperties dataSourceProperties;


    // AuthorizationEndpoint  是用于授权服务请求的。默认的URL是：/oauth/authrize
    // TokenEndpoint  是用于获取访问令牌（Access Tokens）的请求。默认的URL是：/oauth/token
    // AuthorizationServerEndpointsConfigurer:定义了授权和令牌端点和令牌服务
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        super.configure(endpoints);

        final JdbcTokenStore tokenStore = new JdbcTokenStore(dataSource);

        // 配置TokenServices参数
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore);
        tokenServices.setSupportRefreshToken(false);
        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
        tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
        tokenServices.setAccessTokenValiditySeconds( (int) TimeUnit.DAYS.toSeconds(30));

        endpoints
                .authenticationManager(authenticationManager)
                // ？？？？？？？？？？AuthenticationProvider也可以注入
//                .userDetailsService(userDetailsService)
                .tokenStore(tokenStore)
                .tokenServices(tokenServices)
                // ？？？？？？？？？？tokenEnhancer也可以注入
//                .reuseRefreshTokens(true)
//                .authorizationCodeServices(authorizationCodeServices)
        ;

        if (tokenEnhancer != null)
            endpoints.tokenEnhancer(tokenEnhancer);
        if (tokenEnhancer != null)
            endpoints.accessTokenConverter(jwtAccessTokenConverter);

    }

    @Autowired
    JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    TokenEnhancer tokenEnhancer;

    // AuthorizationServerSecurityConfigurer:在令牌端点上定义了安全约束
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);

        security.checkTokenAccess("permitAll()");
        security.allowFormAuthenticationForClients();
    }


    // ClientDetailsServiceConfigurer:定义了客户端细节服务。客户详细信息可以被初始化,或者你可以参考现有的商店
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        super.configure(clients);

        clients
//                .jdbc(dataSource)
                .withClientDetails(new JdbcClientDetailsService(dataSource));
    }





}


