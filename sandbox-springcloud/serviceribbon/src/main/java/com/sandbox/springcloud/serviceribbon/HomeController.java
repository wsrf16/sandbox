package com.sandbox.springcloud.serviceribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Service
public class HomeController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/hi")
//    @HystrixCommand(fallbackMethod = "hiError")
    public String hi(@RequestParam String name) {
        return restTemplate.getForObject("http://service-hi/hi?name=" + name, String.class);
    }

    public String hiError(String name) {
        return "sorry, " + name + ", error!";
    }
}


