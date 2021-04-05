//package com.example.demo.Cache;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//
////@Service
////@Configuration
//@Component
//@Lazy(false)
//public class RedisCache {
//
//    @Autowired
//    public StringRedisTemplate stringRedisTemplate;                 // 1Spring Boot已为我们配置StringRedisTemplate，在此处可以直接注入。
//    @Autowired
//    public RedisTemplate<Object, Object> redisTemplate;             // 2Spring Boot已为我们配置RedisTemplate，在此处可以直接注入。
//
//    public ValueOperations<String, String> getStringStringValueOperations() {
//        return stringRedisTemplate.opsForValue();
//    }
//
//    public ValueOperations<Object, Object> getValueOperations(){
//        return redisTemplate.opsForValue();
//    }
//
//}
