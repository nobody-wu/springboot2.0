package com.example.springboot2docker.controller;

import com.example.springboot2docker.service.factory.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 17:37 2019/1/14
 */
@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @PostMapping(value = "/async")
    public void test(){
        for (int i =0 ;i<10;i++){
            asyncService.async1();
            asyncService.async2();
        }
    }

}

