package com.example.springboot2docker.manager;

import com.alibaba.fastjson.JSONObject;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class SystemExceptionThrowsAdvice implements MethodBeforeAdvice,AfterReturningAdvice {

    /**
     * spring3.X之前的方法
     *
     * 需要实现 ThrowsAdvice
     *
     * @param method
     * @param args
     * @param target
     * @param ex
     * @throws Throwable
     */
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {
        System.out.println("【SystemExceptionThrowsAdvice】method：" + method + "，args：" + JSONObject.toJSONString(args) + ",target:" + JSONObject.toJSONString(target) + ",ex:" + JSONObject.toJSONString(ex));
    }

    @Override
    public void afterReturning(@Nullable Object o, Method method, Object[] objects, @Nullable Object o1) throws Throwable {
        System.out.println("【SystemExceptionThrowsAdvice】在方法之后method：" + method + "，Object：" + JSONObject.toJSONString(o) + ",objects[]:" + JSONObject.toJSONString(objects) + ",Object1:" + JSONObject.toJSONString(o1));
    }

    @Override
    public void before(Method method, Object[] objects, @Nullable Object o) throws Throwable {
        System.out.println("【SystemExceptionThrowsAdvice】在方法之前method：" + method + "，Object：" + JSONObject.toJSONString(o) + ",objects[]:" + JSONObject.toJSONString(objects));
    }
}
