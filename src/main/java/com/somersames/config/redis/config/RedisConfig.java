package com.somersames.config.redis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisShardInfo;

/**
 * @author szh
 * @create 2019-03-06 23:49
 **/
@Configuration@Order(1)
@Slf4j
public class RedisConfig {


    @Bean(name = "redis1")
    @Primary
    JedisConnectionFactory jedisConnectionFactory1(){
        JedisConnectionFactory jedisConnectionFactory =new JedisConnectionFactory();
        jedisConnectionFactory.setHostName("127.0.0.1");
        // TODO 换成自己的ip
        jedisConnectionFactory.setPort(6379);
        jedisConnectionFactory.setPassword("123456");
        jedisConnectionFactory.setDatabase(0);
        return jedisConnectionFactory;
    }

    @Bean(name = "redis2")
    JedisConnectionFactory jedisConnectionFactory2(){
        JedisConnectionFactory jedisConnectionFactory =new JedisConnectionFactory();
        jedisConnectionFactory.setHostName("127.0.0.1");
        // TODO 换成自己的ip
        jedisConnectionFactory.setPort(6379);
        jedisConnectionFactory.setPassword("123456");
        jedisConnectionFactory.setDatabase(2);
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(jedisConnectionFactory1());
        return template;
    }
    @Bean
    public RedisTemplate<String, Object> redisTemplate2() {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(jedisConnectionFactory2());
        return template;
    }
}
