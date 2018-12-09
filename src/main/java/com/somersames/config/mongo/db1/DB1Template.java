package com.somersames.config.mongo.db1;

/**
 * @author szh
 * @create 2018-12-09 23:16
 **/

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

@Configuration
@EnableMongoRepositories(mongoTemplateRef = "mongoDB1")
public class DB1Template {

    @Autowired
    @Qualifier("mongodb1")
    private MongoProperties mongoProperties;

    @Bean(name = "mongoDB1")
    public MongoTemplate db1Template(){
        return new MongoTemplate(db1Factory(mongoProperties));
    }

    @Bean
    public MongoDbFactory db1Factory(MongoProperties mongoProperties){
        return new SimpleMongoDbFactory(new MongoClient(mongoProperties.getHost(),mongoProperties.getPort()),mongoProperties.getDatabase());
    }
}
