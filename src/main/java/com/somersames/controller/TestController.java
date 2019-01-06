package com.somersames.controller;

import com.somersames.dto.mysql.Curd;
import com.somersames.dto.mysql.User;
import com.somersames.service.mysql.CurdService;
import com.somersames.service.mysql.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author szh
 * @create 2019-01-05 16:04
 **/
@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    CurdService curdService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/curd",method = RequestMethod.GET)
    public List<Curd> testCurd(){
        return curdService.queryCurd();
    }
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public List<User> testUser(){
        return userService.queryUsers();
    }

}
