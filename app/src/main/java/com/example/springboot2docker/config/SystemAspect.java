package com.example.springboot2docker.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: wujiapeng
 * @Description: spring注解aop Aspect各种advice
 *
 * <aop:aspectj-autoproxy /> : 通过配置织入@Aspectj切面
 * 虽然可以通过编程的方式织入切面，但是一般情况下，我们还是使用spring的配置自动完成创建代理织入切面的工作。
 * 通过aop命名空间的<aop:aspectj-autoproxy />声明自动为spring容器中那些配置@aspectJ切面的bean创建代理，织入切面。
 * 当然，spring在内部依旧采用AnnotationAwareAspectJAutoProxyCreator进行自动代理的创建工作，
 * 但具体实现的细节已经被<aop:aspectj-autoproxy />隐藏起来了
 * <aop:aspectj-autoproxy />有一个proxy-target-class属性，默认为false，表示使用jdk动态代理织入增强，
 * 当配为<aop:aspectj-autoproxy  poxy-target-class="true"/>时，表示使用CGLib动态代理技术织入增强。
 * 不过即使proxy-target-class设置为false，如果目标类没有声明接口，则spring将自动使用CGLib动态代理。
 *
 * try{
 *   try{
 *      //@Before
 *      method.invoke(..);
 *   }finally{
 *      //@After
 *   }
 *      //@AfterReturning
 *   }catch(){
 *      //@AfterThrowing
 *   }
 *
 * @Date: created in 14:35 2018/7/13
 */
@Aspect
@Component
@Order(value = 1)
public class SystemAspect {

//    @Pointcut("execution(* com.example.springboot2docker.service*.*(..))")
    @Pointcut("execution(* com.example.springboot2docker.controller.*.*(..))")
    public void pointCut(){}

    /**
     * 环绕通知
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("【SystemAspect】this is around....");
        return joinPoint.proceed();
    }

    /**
     * 前置通知
     */
    @Before(value = "pointCut()")
    public void before(){
        System.out.println("【SystemAspect】this is before....");
    }

    /**
     * 后置通知
     */
    @After(value = "pointCut()")
    public void after(){
        System.out.println("【SystemAspect】this is after....");
    }

    /**
     * 处理将在目标方法正常完成后被织入
     *
     * returning : 指定一个返回值形参名，增强处理定义的方法可通过该行参名来访问目标方法的返回值。
     *
     * @param joinPoint
     */
    @AfterReturning(value = "pointCut()")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("【SystemAspect】afterReturning advise...");
    }

    /**
     * 异常通知
     * @param joinPoint
     */
    @AfterThrowing(value = "pointCut()")
    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("【SystemAspect】afterThrowing advise...");
    }

}
