package com.example.springboot2docker.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springboot2docker.service.AppUserMessageService;
import com.robert.vesta.service.intf.IdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @Resource
    private AppUserMessageService appUserMessageService;

    public IDController() {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring/vesta-rest-main.xml");

        idService = (IdService) ac.getBean("idService");
    }

    @RequestMapping("/id")
    public void getId(){
        logger.info(JSONObject.toJSONString(idService.genId()));
        logger.trace(JSONObject.toJSONString(idService.genId()));
    }

    @RequestMapping("/asyncId")
    public void asyncId(){
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                long l1 = System.currentTimeMillis();
                for(int i=0;i<1000000;i++){

                    logger.info("线程1,"+JSONObject.toJSONString(idService.genId()));
                }
                long l2 = System.currentTimeMillis();
                System.err.println("线程1："+(l2-l1));
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long l1 = System.currentTimeMillis();
                for(int i=0;i<1000000;i++){
                    logger.info("线程2,"+JSONObject.toJSONString(idService.genId()));
                }
                long l2 = System.currentTimeMillis();
                System.err.println("线程2："+(l2-l1));
            }
        });

        t1.start();
        t2.start();

    }

}
