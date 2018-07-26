package com.example.springboot2docker.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 21:00 2018/7/25
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("people", new PeopleBeanDefinitionParser());
    }
}

