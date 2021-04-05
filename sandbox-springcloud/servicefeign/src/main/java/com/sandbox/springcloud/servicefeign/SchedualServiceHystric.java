package com.sandbox.springcloud.servicefeign;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHystric implements SchedualService {
    @Override
    public String sayHiFromClientOne(String name) {
        return "hi " + name + ", feign error!";
    }
}
