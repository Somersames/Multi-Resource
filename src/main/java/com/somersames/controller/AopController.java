package com.somersames.controller;

import com.somersames.aopTest.AopMain;
import com.somersames.service.MongoService;
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


    @RequestMapping(value = "/aop",method = RequestMethod.GET)
    public void testCurd(){
        aopMain.say();
    }
}
