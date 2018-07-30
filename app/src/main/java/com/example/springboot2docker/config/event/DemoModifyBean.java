package com.example.springboot2docker.config.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 17:32 2018/7/26
 */
public class DemoModifyBean implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 发生动作，通过观察者模式，进行通知
     * @param name
     */
    public void modify(String name){
        DemoEvent event = new DemoEvent(applicationContext, name);
        applicationContext.publishEvent(event);
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/spring-event.xml");
        DemoModifyBean demoModifyBean = new DemoModifyBean();
        demoModifyBean.setApplicationContext(context);
        demoModifyBean.modify("wujiapeng");
    }
}
