package com.sandbox.console.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import com.sandbox.console.proxy.UserDao;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    //传入增强的对象
    public UserDao userDao;

    public CglibProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(userDao.getClass());
        enhancer.setCallback(this);
        UserDao proxy = (UserDao) enhancer.create();
        return proxy;
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if ("save".equals(method.getName())) {
            System.out.println("enhance function");
            return methodProxy.invokeSuper(proxy, args);
        }
        return methodProxy.invokeSuper(proxy, args);
    }
}