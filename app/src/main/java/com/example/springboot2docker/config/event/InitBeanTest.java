package com.example.springboot2docker.config.event;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: wujiapeng
 * @Description:
 *
 * 执行顺序：
 * ----> InitSequenceBean: Construct:
 * ----> InitSequenceBean: postConstruct:
 * ----> InitSequenceBean: afterPropertiesSet:
 * ----> InitSequenceBean: onApplicationEvent:
 *
 * @Date: created in 18:03 2018/7/26
 */
@Component
public class InitBeanTest implements InitializingBean,ApplicationListener<ContextRefreshedEvent>  {

    public InitBeanTest() {
        System.err.println("----> InitSequenceBean: Construct: ");
    }

    @PostConstruct
    public void postConstruct() {
        System.err.println("----> InitSequenceBean: postConstruct: ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("----> InitSequenceBean: afterPropertiesSet: ");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.err.println("----> InitSequenceBean: onApplicationEvent: ");
    }
}
