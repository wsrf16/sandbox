package com.sandbox.console.principle;

public class ConstructionTest {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("Singleton1 value1:" + Singleton.value1);
        System.out.println("Singleton1 value2:" + Singleton.value2);

        Singleton2 singleton2 = Singleton2.getInstance2();
        System.out.println("Singleton2 value1:" + Singleton2.value1);
        System.out.println("Singleton2 value2:" + Singleton2.value2);
    }



    static class Singleton {
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
    }

    static class Singleton2 {
        public static int value1;
        public static int value2 = 0;
        private static Singleton2 singleton2 = new Singleton2();

        private Singleton2() {
            value1++;
            value2++;
        }

        public static Singleton2 getInstance2() {
            return singleton2;
        }

    }
}




