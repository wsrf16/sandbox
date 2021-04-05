package com.dubbo.consumer;

import com.dubbo.provider.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Reference
    private HelloService service;

    @Override
    public void run(String... args) throws Exception {
        String hello = service.hello("everyone");
        System.out.println(hello);
    }
}
