package com.example.springboot2docker.annotation;

import java.lang.annotation.*;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 15:00 2018/6/27
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface FeizhuSubmit {

    String value() default "";
}
