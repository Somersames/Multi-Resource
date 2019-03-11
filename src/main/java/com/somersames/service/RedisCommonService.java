package com.somersames.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author szh
 * @create 2019-03-11 23:30
 **/
@Service
public class RedisCommonService {
    @Autowired
    RedisTemplate<String,Object> redisTemplate ;

    @Autowired
    RedisTemplate<String,Object> redisTemplate2 ;

    public void redis1Save(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }

    public void redis1Save2(String key,String value) {
        redisTemplate2.opsForValue().set(key, value);
    }
}
