package com.sandbox.springboot.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configur extends Inheri {
    @Bean("bbbAnn")
    public Ann configurAnn() {
    return new Ann();
    }
}
