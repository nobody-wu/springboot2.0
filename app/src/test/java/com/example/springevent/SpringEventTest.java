package com.example.springevent;

import com.example.springboot2docker.Springboot2DockerApplication;
import com.example.springboot2docker.config.event.DemoModifyBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 17:37 2018/7/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot2DockerApplication.class)
public class SpringEventTest {

    @Test
    public void test(){
        // 使用spring-event.xml来作为spring上下文进行监听
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/spring-event.xml");
        DemoModifyBean demoModifyBean = new DemoModifyBean();
        demoModifyBean.setApplicationContext(context);
        demoModifyBean.modify("wujiapeng");
    }

}
