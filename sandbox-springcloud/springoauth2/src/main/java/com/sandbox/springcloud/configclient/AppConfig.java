package com.sandbox.springcloud.configclient;

import com.sandbox.springcloud.configclient.customoauth.CustomAuthenticationProvider;
import com.sandbox.springcloud.configclient.defaultoauth.DefaultAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

}
