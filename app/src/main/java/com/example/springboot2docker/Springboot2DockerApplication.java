package com.example.springboot2docker;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ImportResource(value = "classpath:spring/*.xml")
@MapperScan(value = "com.example.springboot2docker.mapper")
@EnableTransactionManagement
//@EnableAutoConfiguration(exclude={
//		JpaRepositoriesAutoConfiguration.class //禁止springboot自动加载持久化bean 解决报错：At least one JPA metamodel must be present!
//})
public class Springboot2DockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2DockerApplication.class, args);
    }
}
