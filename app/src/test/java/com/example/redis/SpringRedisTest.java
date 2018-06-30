package com.example.redis;

import com.example.springboot2docker.Springboot2DockerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: wujiapeng
 * @Description: 实现消息队列-发布／订阅模式
 * @Date: created in 14:06 2018/6/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot2DockerApplication.class)
public class SpringRedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedisStringOps() {
        stringRedisTemplate.convertAndSend("string-topic","hello world");

    }

}
