package com.sandbox.javaagent;

import net.bytebuddy.implementation.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;


public class CustomInterceptDelegation {
    @RuntimeType
    public static Object dynamicIntercept(@This Object proxy,
                                          @AllArguments Object[] arguments,
                                          @Origin Class clazz,
                                          @Origin Method method,
                                          @SuperCall Callable<?> callable) throws Exception {
        if (proxy.getClass().getTypeName().equals("com.mysql.cj.jdbc.ConnectionImpl")) {
            if (method.toString().contains("getConnection"))
                // com.mysql.cj.jdbc.ConnectionImpl.getConnection
                return callable.call();
            if (method.toString().contains("createStatement"))
                // com.mysql.cj.jdbc.ConnectionImpl.createStatement
                return callable.call();
        }

        if (proxy.getClass().getTypeName().equals("com.sandbox.console.Main")) {
            if (method.toString().contains("main"))
                return callable.call();
        }

        if (proxy.getClass().getTypeName().equals("com.sandbox.console.DriverClass")) {
            if (method.toString().contains("statichello"))
                return callable.call();
            if (method.toString().contains("dynamichello"))
                return callable.call();
        }

        if (proxy.getClass().getTypeName().equals("java.sql.DriverManager")) {
            return callable.call();
        }

        return callable.call();
    }

    @RuntimeType
    public static Object staticIntercept(@AllArguments Object[] arguments,
                                         @Origin Class clazz,
                                         @Origin Method method,
                                         @SuperCall Callable<?> callable) throws Exception {
//            if (method.toString().contains("java.sql.DriverManager.getConnection"))
        if (method.toString().contains("getConnection"))
            return callable.call();
        if (method.toString().contains("createStatement"))
            return callable.call();
        return callable.call();
    }

    @RuntimeType
    public void intercept() throws Exception {
        long start = System.currentTimeMillis();
        if (1 == 1)
            return;
    }


}
