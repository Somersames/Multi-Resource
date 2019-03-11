package com.somersames.controller;

import com.somersames.aopTest.AopMain;
import com.somersames.service.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author szh
 * @create 2019-03-05 22:31
 **/
@RestController
@RequestMapping("/")
public class AopController {

    @Autowired
    AopMain aopMain;

    @Autowired
    RedisService redisService;
    @RequestMapping(value = "/aop",method = RequestMethod.GET)
    public void testCurd(){
        aopMain.say();
    }

    @RequestMapping(value = "/redis",method = RequestMethod.GET)
    public void testCurd1(){
        redisService.aopRedis("redisTemplate2");
    }
}
