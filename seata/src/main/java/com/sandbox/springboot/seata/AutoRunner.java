package com.sandbox.springboot.seata;

import com.sandbox.springboot.seata.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoRunner implements ApplicationRunner {
    @Autowired
    BusinessService businessService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            businessService.purchase("tom", "amani-m001",  100);
        } catch (Exception e) {
            e.printStackTrace();
//            com.alibaba.nacos.client.config.NacosConfigService
        }
    }
}
