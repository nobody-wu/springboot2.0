package com.example.springboot2docker.config.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author: wujiapeng
 * @Description:i
 * @Date: created in 17:30 2018/7/26
 */
@Component
public class DemoApplicationListener implements ApplicationListener<ApplicationEvent> {

    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (!(applicationEvent instanceof DemoEvent)) {
            return;
        }

        DemoEvent demoEvent = (DemoEvent) applicationEvent;
        System.out.println("this is :" + demoEvent.getName());
    }
}
