package com.somersames.controller;

import com.somersames.dto.mysql.Curd;
import com.somersames.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author szh
 * @create 2019-03-04 23:36
 **/
@RestController
@RequestMapping("/")
public class MongoTest {

    @Autowired
    MongoService mongoService;


    @RequestMapping(value = "/mongo",method = RequestMethod.GET)
    public void testCurd(){
        mongoService.mongoUpdate();
    }
}
