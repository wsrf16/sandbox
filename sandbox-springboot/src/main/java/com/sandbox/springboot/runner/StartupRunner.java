package com.sandbox.springboot.runner;

import com.sandbox.springboot.annotation.ContextConfiguration;
import com.sandbox.springboot.annotation.GreaterThan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * Created by MPC on 2018/3/16.
 */
@Component
@Order(1)
//@GreaterThan(target = "mmmm", value = "nnnnnn")
//@ContextConfiguration(locations = "abc", value = "cba")
public class StartupRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        ContextConfiguration declaredAnnotation1 = StartupRunner.class.getDeclaredAnnotation(ContextConfiguration.class);

        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 11111111 <<<<<<<<<<<<<");
    }

}
