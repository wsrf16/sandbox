package com.sandbox.springcloud.servicefeign;

import feign.hystrix.FallbackFactory;

import java.util.concurrent.TimeoutException;

public class SchedualServiceFallbackFactory implements FallbackFactory<SchedualService> {
    @Override
    public SchedualService create(Throwable throwable) {
        if (throwable instanceof TimeoutException)
            return null;
        else
            return null;
    }
}
