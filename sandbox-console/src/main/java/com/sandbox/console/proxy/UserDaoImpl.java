package com.sandbox.console.proxy;

public class UserDaoImpl implements UserDao {
    @Override
    public void insert() {
        System.out.println("insert");
    }
    @Override
    public void delete() {
        System.out.println("delete");

    }
    @Override
    public void update() {
        System.out.println("update");

    }
    @Override
    public void query() {
        System.out.println("query");
    }
}