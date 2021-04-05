package com.sandbox.console.proxy;

import com.sandbox.console.proxy.UserDao;
import com.sandbox.console.proxy.UserDaoImpl;
import com.sandbox.console.proxy.jdk.JDKProxy;

public class JDKProxyTest {
    public static void main() {
        UserDao userDao = new UserDaoImpl();
        UserDao proxy = new JDKProxy(userDao).createProxy();
        proxy.insert();
        proxy.delete();
        proxy.update();
        proxy.query();
    }
}
