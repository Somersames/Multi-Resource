package com.somersames.service;

import com.somersames.config.mongo.config.UseMongo;
import com.somersames.config.mongo.db1.DB1Template;
import com.somersames.config.mongo.db2.DB2Repository;
import com.somersames.config.mongo.db2.DB2Template;
import com.somersames.constant.MongoConstant;
import com.somersames.dto.mongo.MongoDB1;
import com.somersames.dto.mongo.MongoDB2;
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
    DB2Repository db2Repository;

    @UseMongo
    public void mongoUpdate(){
        db2Repository.save(new MongoDB2());
    }
}
