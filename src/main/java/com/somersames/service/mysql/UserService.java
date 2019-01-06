package com.somersames.service.mysql;

import com.somersames.config.mysql.config.UseDataSource;
import com.somersames.dao.UserMapper;
import com.somersames.dto.mysql.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author szh
 * @create 2019-01-05 20:06
 **/
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @UseDataSource(name = "mysql2")
    public List<User> queryUsers(){
        List<User> list = userMapper.selectAll();
        return list;
    }
}
