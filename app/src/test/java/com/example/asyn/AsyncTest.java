package com.example.asyn;

import com.example.springboot2docker.Springboot2DockerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 17:31 2019/1/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot2DockerApplication.class)
public class AsyncTest {

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            async1();
            async2();
        }
    }

    @Async
    public void async1() {
        System.out.println("线程名称：" + Thread.currentThread().getName() + " be ready to read data!");
    }

    @Async
    public void async2() {
        System.out.println("线程名称：" + Thread.currentThread().getName() + " be ready to read data!");
    }

}
