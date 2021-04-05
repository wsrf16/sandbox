package com.dubbo.provider.service;


import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

//@Component
@Service(timeout = 60000,interfaceClass = HelloService.class)
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String word) {
        System.out.println(word);
        return word;
    }
}
