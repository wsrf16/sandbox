package com.sandbox.springcloud.configclient;

import com.sandbox.springcloud.configclient.common.AuthorizedGrantTypeEnum;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

//@Configuration
public class TestAuthorizationAdapter extends AuthorizationServerConfigurerAdapter {
    public TestAuthorizationAdapter() {
        super();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        super.configure(endpoints);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        super.configure(clients);
        clients.inMemory() // 使用in-memory存储
                .withClient("client") // client_id
                .secret("secret") // client_secret
                .authorizedGrantTypes(AuthorizedGrantTypeEnum.AUTHORIZATION_CODE) // 该client允许的授权类型
//                .authorizedGrantTypes(AuthorizedGrantTypeEnum.AUTHORIZATION_CODE,
//                        AuthorizedGrantTypeEnum.REFRESH_TOKEN,
//                        AuthorizedGrantTypeEnum.PASSWORD,
//                        AuthorizedGrantTypeEnum.IMPLICIT)
                .scopes("app"); // 允许的授权范围
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
    }

}


