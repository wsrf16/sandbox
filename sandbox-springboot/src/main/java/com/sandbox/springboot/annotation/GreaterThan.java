package com.sandbox.springboot.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface GreaterThan {
    @AliasFor("target")
    String value() default "";

    @AliasFor("value")
    String target() default "";
}
