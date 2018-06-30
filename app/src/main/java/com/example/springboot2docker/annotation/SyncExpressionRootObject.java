package com.example.springboot2docker.annotation;

import java.lang.reflect.Method;

public class SyncExpressionRootObject {
    private Object target;
    private Method method;
    private Object[] arguments;

    public SyncExpressionRootObject(Object target, Method method, Object[] arguments) {
        this.target = target;
        this.method = method;
        this.arguments = arguments;
    }

    public String getClassMethod() {
        return target.getClass().getName() + "." + method.getName();
    }

    public Object getTarget() {
        return target;
    }

    public Method getMethod() {
        return method;
    }

    public String getClassName() {
        return target.getClass().getName();
    }

    public String getMethodName() {
        return method.getName();
    }

    public Object[] getArguments() {
        return arguments;
    }
}
