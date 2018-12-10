package com.somersames.service;

import com.somersames.config.mongo.db1.DB1Template;
import com.somersames.constant.MongoConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * @author szh
 * @create 2018-12-07 0:07
 **/
@Service
public class MongoService {
    @Autowired
    DB1Template db1Template;

    // @Description Mongo的更新语法
    public void mongoUpdate(){
        db1Template.db1Template().updateFirst(new Query(Criteria.where("_id").is("ad")),new Update().set("remark","da"), MongoConstant.MongoDB1);
    }
}
