package com.somersames.service.mysql;

import com.somersames.config.mysql.config.UseDataSource;
import com.somersames.dao.CurdMapper;
import com.somersames.dto.mysql.Curd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author szh
 * @create 2019-01-05 19:37
 **/
@Service
public class CurdService {

    @Autowired
    CurdMapper curdMapper;

    @UseDataSource(name = "mysql1")
    public List<Curd> queryCurd(){
        List<Curd> list =  curdMapper.selectAll();
        return list;
    }
}
