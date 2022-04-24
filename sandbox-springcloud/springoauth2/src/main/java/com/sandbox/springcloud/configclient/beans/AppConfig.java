package com.sandbox.springcloud.configclient.beans;

import com.sandbox.springcloud.configclient.customoauth.CustomAuthenticationProvider;
import com.sandbox.springcloud.configclient.defaultoauth.DefaultAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {
    @Bean("customAuthenticationProvider")
    public CustomAuthenticationProvider getCustomAuthenticationProvider() {
        return new CustomAuthenticationProvider();
    }

    @Bean("defaultAuthenticationProvider")
    public DefaultAuthenticationProvider getDefaultAuthenticationProvider() {
        return new DefaultAuthenticationProvider();
    }


    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        KeyStoreKeyFactory factory = new KeyStoreKeyFactory(
//                new ClassPathResource("youlai.jks"), "123456".toCharArray());
//        KeyPair keyPair = factory.getKeyPair(
//                "youlai", "123456".toCharArray());
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setKeyPair(keyPair);
        return converter;
    }

    @Bean
    public TokenEnhancer tokenEnhancer() {
        return (accessToken, authentication) -> {
            Map<String, Object> map = new HashMap<>();
//            User user = (User) authentication.getUserAuthentication().getPrincipal();
//            map.put(AuthConstants.JWT_USER_ID_KEY, user.getId());
//            map.put(AuthConstants.JWT_CLIENT_ID_KEY, user.getClientId());
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(map);
            return accessToken;
        };
    }
}
