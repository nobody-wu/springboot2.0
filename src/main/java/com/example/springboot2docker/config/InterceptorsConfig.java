package com.example.springboot2docker.config;

import com.example.springboot2docker.annotation.FeizhuSubmitInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 申明拦截器
 */
@Configuration
public class InterceptorsConfig extends WebMvcConfigurerAdapter {
}
