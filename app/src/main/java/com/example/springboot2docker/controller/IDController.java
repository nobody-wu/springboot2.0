package com.example.springboot2docker.controller;

import com.alibaba.fastjson.JSONObject;
import com.robert.vesta.service.intf.IdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wujiapeng
 * @Description: vesta发号器
 * @Date: created in 16:24 2018/7/11
 */
@RestController
@RequestMapping(value = "/id-generator")
public class IDController {

    private Logger logger = LoggerFactory.getLogger(IDController.class);

    private IdService idService;

    public IDController() {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring/vesta-rest-main.xml");

        idService = (IdService) ac.getBean("idService");
    }

    @RequestMapping("/id")
    public void getId(){
        logger.info(JSONObject.toJSONString(idService.genId()));
    }

}
