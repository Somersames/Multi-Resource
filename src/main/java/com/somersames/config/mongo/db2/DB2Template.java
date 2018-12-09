package com.somersames.config.mongo.db2;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author szh
 * @create 2018-12-09 23:28
 **/
@Configuration
@EnableMongoRepositories(mongoTemplateRef = "mongoDB2")
public class DB2Template {

    @Autowired
    @Qualifier("mongodb2")
    private MongoProperties mongoProperties;

    @Bean("mongoDB2")
    public MongoTemplate db2Template(){
        return new MongoTemplate(db2Factory(mongoProperties));
    }

    @Bean
    public MongoDbFactory db2Factory(MongoProperties mongoProperties){
        return new SimpleMongoDbFactory(new MongoClient(mongoProperties.getHost(),mongoProperties.getPort()),mongoProperties.getDatabase());
    }

}
