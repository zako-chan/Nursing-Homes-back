package com.example.ex3_2_back.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

//Redis配置类
@Configuration
public class RedisConfiguration {

    // 注入Redis连接工厂，用于创建Redis连接
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    //配置Redis消息监听容器，用于监听Redis的消息。
    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer() {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        // 设置连接工厂
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        return redisMessageListenerContainer;
    }

    //配置Redis的字符串序列化
    @Bean("myRedisTemplate")
    @SuppressWarnings("all")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        // 配置key的序列化器为字符串序列化器
        template.setKeySerializer(new StringRedisSerializer());
        // 配置value的序列化器为JSON序列化器
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // 配置hash key的序列化器为字符串序列化器
        template.setHashKeySerializer(new StringRedisSerializer());
        // 配置hash value的序列化器为JSON序列化器
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        // 设置连接工厂
        template.setConnectionFactory(factory);
        return template;
    }

}