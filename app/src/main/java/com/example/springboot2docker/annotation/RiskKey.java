package com.example.springboot2docker.annotation;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: yujianfu (mr.vencnet@gmail.com)
 * Date: 2018/9/20
 * Time: 下午2:09
 */
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
