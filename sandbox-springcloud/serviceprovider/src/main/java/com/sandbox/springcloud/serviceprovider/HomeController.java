package com.sandbox.springcloud.serviceprovider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Value("${server.port}")
    String port;
    @GetMapping("/hi")
    public String hi(@RequestParam String name) {
        return spell(name);
    }

    public String spell(String name) {
        return "Hi "+name+".I am from port:" +port;
    }
}
