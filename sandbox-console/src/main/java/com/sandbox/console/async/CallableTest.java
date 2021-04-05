package com.sandbox.console.async;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public void main() {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() {
                String c = "callable";
                System.out.println(c);
                return c;
            }
        };

        FutureTask<String> futureTask = new FutureTask<String>(callable);
        Thread oneThread = new Thread(futureTask);
        oneThread.start();
        try {
            String v = futureTask.get();
            System.out.println(v);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
