package com.sandbox.springcloud.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class })
@EnableAuthorizationServer
//@ComponentScan(basePackages={"com.sandbox.demo","com.sandbox.demo.defaultoauth","com.sandbox.demo.customoauth"})
public class SpringOAuth2Application {
	public static void main(String[] args) {
		SpringApplication.run(SpringOAuth2Application.class, args);

	}
}