package com.sandbox.springboot;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableSwagger2
public class SpringbootSandboxApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringbootSandboxApplication.class);

	public static void main(String[] args) {
		//SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringbootdemoApplication.class);
		//builder.bannerMode(Banner.Mode.OFF).run(args);
		//lombok
		//log.error("eeeee1");
		logger.info("SpringbootBackyardApplication start.^_^");
		SpringApplication.run(SpringbootSandboxApplication.class, args);
		//log.error("eeeee2");
		logger.info("SpringbootBackyardApplication start.^_^2");
	}

	@Bean(initMethod = "postConstruct",destroyMethod = "preDestroy")
	public TestInitOrDispose testInitOrDispose(){
		return new TestInitOrDispose();
	}

//	@Bean
//	public FilterRegistrationBean indexFilterRegistration() {
//		FilterRegistrationBean registration = new FilterRegistrationBean(new GlobalFilter());
//		registration.addUrlPatterns("/*");
//		return registration;
//	}
}
