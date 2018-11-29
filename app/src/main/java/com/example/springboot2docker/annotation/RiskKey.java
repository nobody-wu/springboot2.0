package com.example.springboot2docker.annotation;

import java.lang.annotation.*;

@Inherited
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RiskKey {
    String key() default "";

    String[] keys() default {};

    boolean isString() default false;

    boolean isInteger() default  false;
}
