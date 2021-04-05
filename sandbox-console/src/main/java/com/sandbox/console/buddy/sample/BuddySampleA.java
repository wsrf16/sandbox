package com.sandbox.console.buddy.sample;


import com.aio.portable.swiss.suite.bytecode.bytebuddy.sample.annotation.JavaAgentInterceptor;

@JavaAgentInterceptor
public class BuddySampleA {
    public void print() {
        System.out.println(this.getClass());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
