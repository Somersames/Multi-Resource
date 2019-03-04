package com.somersames.config.mongo.db2;

import com.somersames.dto.mongo.MongoDB1;
import com.somersames.dto.mongo.MongoDB2;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author szh
 * @create 2018-12-09 23:40
 **/
@Repository
public interface DB2Repository extends MongoRepository<MongoDB2,String>{
}
