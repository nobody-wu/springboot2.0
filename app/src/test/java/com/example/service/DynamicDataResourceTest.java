package com.example.service;

import com.example.springboot2docker.Springboot2DockerApplication;
import com.example.springboot2docker.service.AppUserMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 18:05 2018/7/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot2DockerApplication.class)
public class DynamicDataResourceTest {

    @Resource
    private AppUserMessageService appUserMessageService;

    @Test
    public void test(){
        System.out.println(appUserMessageService.selectByPrimaryKey("xtt"));
    }


}
