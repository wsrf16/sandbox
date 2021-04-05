package com.sandbox.springcloud.servicefeign;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

//@Configuration
public class FeignHystrixConfiguration {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }


//    @Bean
//    public Contract feignConfiguration(){
//        return new feign.Contract.Default();
//    }
}
