package com.sandbox.springboot.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class Inheri {
    @Bean("aaaAnn")
    public Ann inheriAnn() {
        return new Ann();
    }
}
