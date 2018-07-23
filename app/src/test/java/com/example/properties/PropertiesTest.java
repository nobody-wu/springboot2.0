package com.example.properties;

import com.example.springboot2docker.Springboot2DockerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: wujiapeng
 * @Description: @Value 属性注入使用
 * @Date: created in 16:05 2018/7/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot2DockerApplication.class)
public class PropertiesTest {

    @Value("normal")
    private String normal; // 注入普通字符串

    @Value("#{systemProperties['os.name']}")
    private String systemPropertiesName; // 注入操作系统属性

    @Value("#{ T(java.lang.Math).random() * 100.0 }")
    private double randomNumber; //注入表达式结果

    @Value("#{beanInject.another}")
    private String fromAnotherBean; // 注入其他Bean属性：注入beanInject对象的属性another，类具体定义见下面

    @Value("#{'${bean}'.split(',')}")
    private List<String> fromOtherBean; // 注入其他Bean属性：注入beanInject对象的属性another，类具体定义见下面

    @Value("classpath:config.txt")
    private Resource resourceFile; // 注入文件资源

    @Value("http://www.baidu.com")
    private Resource testUrl; // 注入URL资源

//    @Value(value = "${com.example.value}")
//    public String value;

    @Test
    public void test(){
        System.out.println(systemPropertiesName);
        System.out.println(randomNumber);
        System.out.println(normal);
        System.out.println(fromAnotherBean);
        System.out.println(resourceFile);
        System.out.println(testUrl);
        System.out.println(fromOtherBean);
//        System.out.println(value);
    }

}
