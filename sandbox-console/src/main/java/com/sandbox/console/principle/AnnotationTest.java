package com.sandbox.console.principle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@AnnotationTest.Flag(isMaster = true, age = 22)
public class AnnotationTest {
    public void test() {
        Class<?> clazz = AnnotationTest.class;
        Flag flag = clazz.getAnnotation(Flag.class);
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
    @interface Flag {
        boolean isMaster() default false;

        int age() default 18;
    }
}


