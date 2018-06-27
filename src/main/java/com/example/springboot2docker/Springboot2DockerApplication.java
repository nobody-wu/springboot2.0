package com.example.springboot2docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = "classpath:spring/*.xml")
public class Springboot2DockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2DockerApplication.class, args);
	}
}
