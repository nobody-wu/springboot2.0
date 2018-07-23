package com.example.springboot2docker.vo;

import org.springframework.stereotype.Component;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 16:11 2018/7/23
 */
@Component
public class BeanInject {
    private String another = "wjp";

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }
}
