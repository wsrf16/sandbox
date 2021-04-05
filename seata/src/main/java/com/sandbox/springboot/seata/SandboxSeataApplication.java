package com.sandbox.springboot.seata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SandboxSeataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SandboxSeataApplication.class, args);
//        com.alibaba.nacos.api.exception.NacosException
    }

}
