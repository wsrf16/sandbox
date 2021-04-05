package com.sandbox.console.proxy.jdk;

import com.sandbox.console.proxy.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {

    private UserDao userDao;

    public JDKProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao createProxy() {
        Class<?>[] userDaoInterfaces = userDao.getClass().getInterfaces();
        UserDao userDaoProxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
                userDao.getClass().getInterfaces(), this);
        return userDaoProxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("update".equals(method.getName())) {
            System.out.println("权限校验");
            return method.invoke(userDao, args);
        }
        return method.invoke(userDao, args);
    }
}
