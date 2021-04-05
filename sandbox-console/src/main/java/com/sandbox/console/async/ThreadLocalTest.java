package com.sandbox.console.async;

public class ThreadLocalTest {
    ThreadLocal threadLocal = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            return super.initialValue();
        }

        @Override
        public Object get() {
            return super.get();
        }

        @Override
        public void set(Object value) {
            super.set(value);
        }

        @Override
        public void remove() {
            super.remove();
        }
    };





}
