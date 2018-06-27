package com.example.springboot2docker.controller;

import com.example.springboot2docker.annotation.FeizhuSubmit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 22:05 2018/6/27
 */
@RestController
@RequestMapping("/annotationValue")
public class AnnotationValueController {

    /**
     * 演示根据sqel表达式传递参数
     * @param num
     */
    @RequestMapping("/test")
    @FeizhuSubmit(value = "#num")
    public void test(@RequestParam Long num){
        System.out.println("test ok...");
    }

}
