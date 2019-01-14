package com.example.springboot2docker.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 17:26 2019/1/14
 */
@Configuration
@EnableAsync // 开启异步
public class AsycConfiguration implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor(){
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        threadPool.setCorePoolSize(2);//当前线程数
        threadPool.setMaxPoolSize(120);// 最大线程数
        threadPool.setQueueCapacity(1);//线程池所使用的缓冲队列
        threadPool.setWaitForTasksToCompleteOnShutdown(true);//等待任务在关机时完成--表明等待所有线程执行完
        threadPool.setAwaitTerminationSeconds(60 * 15);// 等待时间 （默认为0，此时立即停止），并没等待xx秒后强制停止
        threadPool.setThreadNamePrefix("MyAsync-");//  线程名称前缀
        threadPool.initialize(); // 初始化
        System.out.println("--------------------------》》》开启异常线程池");
        return threadPool;
    }

    /**
     * 异常处理
     *
     * @return
     */
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new MyAsyncExceptionHandler();
    }

    /**
     * 自定义异常处理类
     * @author hry
     *
     */
    class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

        //手动处理捕获的异常
        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
            System.out.println("-------------》》》捕获线程异常信息");
            System.out.println("Exception message - " + throwable.getMessage());
            System.out.println("Method name - " + method.getName());
            for (Object param : obj) {
                System.out.println("Parameter value - " + param);
            }
        }

    }
}
