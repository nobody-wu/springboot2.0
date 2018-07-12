package com.example.springboot2docker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 20:41 2018/6/8
 */
@RestController
public class DockerController {

    @RequestMapping("/")
    public String index() {
        return "Hello Docker!";
    }

}