package com.dubbo.provider.service;


import org.apache.dubbo.config.annotation.Reference;

public interface HelloService {
    @Reference(url = "dubbo://localhost:20880")
    String hello(String word);
}