package com.sandbox.console;

public class Singleton {
    private static Singleton singleton = new Singleton();
    public static int value1;
    public static int value2 = 0;

    private Singleton() {
        value1++;
        value2++;
    }

    public static Singleton getInstance() {
        return singleton;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("Singleton1 value1:" + Singleton.value1);
        System.out.println("Singleton1 value2:" + Singleton.value2);
        args[1]="aaaaaaaa";
    }
}