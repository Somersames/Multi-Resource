package com.somersames.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author szh
 * @create 2019-03-07 0:09
 **/
@Service
public class RedisService {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;


    public void a(String reditTemplate){
        redisTemplate.opsForValue().set("a","a");
    }

}
