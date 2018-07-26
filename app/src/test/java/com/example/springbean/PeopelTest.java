package com.example.springbean;

import com.example.springboot2docker.Springboot2DockerApplication;
import com.example.springboot2docker.vo.People;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 09:42 2018/7/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot2DockerApplication.class)
public class PeopelTest {

    @Autowired
    private People people;

    @Test
    public void test(){
        System.out.println(people);
    }

}
