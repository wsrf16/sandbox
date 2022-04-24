package com.sanbox.springboot.sample.nacos;

import com.aio.portable.swiss.suite.net.tcp.http.RestTemplater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AutoRunner implements ApplicationRunner {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        RestTemplater.setProxyRequestFactory(restTemplate, "127.0.0.1", 8888);
        return restTemplate;

    }

    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    public OrderProvider orderProvider;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String result1 = ribbon();
        String result2 = feign();
    }

    private String ribbon() {
        String result = restTemplate.getForObject("http://service-order/order/one", String.class);
        System.out.println(result);
        return result;
    }

    private String feign() {
        String result = orderProvider.one();
        System.out.println(result);
        return result;
    }


    @FeignClient("service-order/order")
    public interface OrderProvider {
        @RequestMapping("/one")
        String one();
    }
}
