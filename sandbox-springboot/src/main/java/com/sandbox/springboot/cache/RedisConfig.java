//package com.example.demo.Cache;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Service;
//import redis.clients.jedis.JedisPoolConfig;
//
//
//public class RedisConfig {
//
//    @Autowired
//    private RedisConnectionFactory redisConnectionFactory;
//
//    @Bean
//    public StringRedisTemplate stringRedisTemplate(){
//        StringRedisTemplate redisTemplate = new StringRedisTemplate(redisConnectionFactory);
//        return redisTemplate;
//    }
//
//
//
////    @Bean
////    @ConfigurationProperties(prefix="spring.redis")
////    public JedisPoolConfig getRedisConfig(){
////        JedisPoolConfig config = new JedisPoolConfig();
////        return config;
////    }
////
////    @Bean
////    @ConfigurationProperties(prefix="spring.redis")
////    public JedisConnectionFactory getConnectionFactory(){
////        JedisConnectionFactory factory = new JedisConnectionFactory();
////        JedisPoolConfig config = getRedisConfig();
////        factory.setPoolConfig(config);
////        //logger.info("JedisConnectionFactory bean init success.");
////        return factory;
////    }
////
////
////    @Bean
////    public RedisTemplate<?, ?> getRedisTemplate(){
////        RedisTemplate<?,?> template = new StringRedisTemplate(getConnectionFactory());
////        return template;
////    }
//}