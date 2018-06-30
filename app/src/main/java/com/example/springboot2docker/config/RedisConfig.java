package com.example.springboot2docker.config;
import org.springframework.cache.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import javax.annotation.Resource;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 13:59 2018/6/24
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport{

    @Resource
    private JedisConnectionFactory jedisConnectionFactory;

    @Bean
    public ConsumerRedisListener consumerRedis(){
        return new ConsumerRedisListener();
    }

    @Bean
    public ChannelTopic topic() {
        return new ChannelTopic("string-topic");
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer() {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(jedisConnectionFactory);

        container.addMessageListener(consumerRedis(),topic());
        return container;

    }
}
