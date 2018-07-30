package com.example.springboot2docker.config.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 17:31 2018/7/26
 */
public class DemoEvent extends ApplicationEvent {

    private String name;

    public DemoEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
