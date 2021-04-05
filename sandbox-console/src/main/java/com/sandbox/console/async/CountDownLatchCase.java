package com.sandbox.console.async;

import java.util.concurrent.CountDownLatch;


public class CountDownLatchCase {
    static int max = 100;
    static CountDownLatch latch = new CountDownLatch(max);

    public static void todo(String[] args) throws InterruptedException {
        for (int i = 0; i < max; i++) {
            new Thread(new Task(i, latch)).start();
        }

        latch.await();
        System.out.println("finish!");
    }

    static class Task implements Runnable {
        CountDownLatch latch;
        int id;

        Task(int id, CountDownLatch latch) {
            this.id = id;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println(id);
            latch.countDown();
        }
    }
}


