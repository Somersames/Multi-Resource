package com.somersames.controller;

import com.somersames.service.RedisCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author szh
 * @create 2019-03-11 23:34
 **/
@RestController
@RequestMapping("/")
public class RedisCommonController {

    @Autowired
    RedisCommonService redisCommonService;

    @RequestMapping(value = "/redis1",method = RequestMethod.GET)
    public void redis1(){
        redisCommonService.redis1Save("1","2");
    }


    @RequestMapping(value = "/redis2",method = RequestMethod.GET)
    public void redis2(){
        redisCommonService.redis1Save2("2","3");
    }
}
