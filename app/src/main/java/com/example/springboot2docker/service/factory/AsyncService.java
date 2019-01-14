package com.example.springboot2docker.service.factory;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author: wujiapeng
 * @Description: 使用@Async申请异步任务，必须写在service中
 *
 * 这种实现方法，所以在同一个类中的方法调用，添加@async注解是失效的！，原因是当你在同一个类中的时候，方法调用是在类体内执行的，spring无法截获这个方法调用。
 *
 * @Date: created in 17:41 2019/1/14
 */
@Service
public class AsyncService {
    @Async
    public void async1(){
        System.out.println("线程名称："+Thread.currentThread().getName() + " be ready to read data!");
    }

    @Async
    public void async2(){
        System.out.println("线程名称："+Thread.currentThread().getName() + " be ready to read data!");
    }
}
