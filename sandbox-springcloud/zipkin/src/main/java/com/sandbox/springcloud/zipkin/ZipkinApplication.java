package com.sandbox.springcloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.internal.EnableZipkinServer;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication//(exclude = {org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration.class})
//@EnableEurekaClient
@EnableZipkinServer
public class ZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class, args);
//        zipkin2.Span
//        ZipkinElasticsearchHttpStorageProperties
    }

}
