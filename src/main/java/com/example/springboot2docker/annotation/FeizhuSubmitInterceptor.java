package com.example.springboot2docker.annotation;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.expression.MethodBasedEvaluationContext;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * @Author: wujiapeng
 * @Description: 演示获取自定义注解内的值
 * @Date: created in 15:01 2018/6/27
 */
@Component
public class FeizhuSubmitInterceptor implements MethodInterceptor, Serializable {
    private final ExpressionParser expressionParser = new SpelExpressionParser();
    private final ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Method method = methodInvocation.getMethod();
        FeizhuSubmit feizhuSubmit = method.getAnnotation(FeizhuSubmit.class);
        if (feizhuSubmit == null || StringUtils.isEmpty(feizhuSubmit.value())) {
            return methodInvocation.proceed();
        }

        EvaluationContext evaluationContext = createEvaluationContext(methodInvocation, method);
        String num = getExpression(feizhuSubmit.value()).getValue(evaluationContext, String.class);
        System.out.println(".....num:"+num);
        return methodInvocation.proceed();
    }

    private EvaluationContext createEvaluationContext(MethodInvocation invocation, Method method) {
        return new MethodBasedEvaluationContext(createRootObject(invocation), method, invocation.getArguments(), parameterNameDiscoverer);
    }

    private SyncExpressionRootObject createRootObject(MethodInvocation invocation) {
        return new SyncExpressionRootObject(invocation.getThis(), invocation.getMethod(), invocation.getArguments());
    }

    private Expression getExpression(String key) {
//        Expression expression = keyCache.get(key);
//        if (expression != null) {
//            return expression;
//        }
        Expression expression = expressionParser.parseExpression(key);
//        keyCache.putIfAbsent(key, expression);
        return expression;
    }
}
