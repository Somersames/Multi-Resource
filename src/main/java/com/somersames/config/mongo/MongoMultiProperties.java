package com.somersames.config.mongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author szh
 * @create 2018-12-09 23:03
 * @description 该类是读取配置类，无非就是将配置文件的mongo配置读取到MongoProperties
 **/
@Configuration
public class MongoMultiProperties {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoMultiProperties.class);

    @Bean(name="mongodb1")
    @Primary
    @ConfigurationProperties(prefix = "spring.data.mongodb.db1")
    public MongoProperties db1Properties(){
        LOGGER.info("正在初始化db1");
        return new MongoProperties();
    }

    @Bean(name = "mongodb2")
    @ConfigurationProperties(prefix = "spring.data.mongodb.db2")
    public MongoProperties db2Properties(){
        LOGGER.info("正在初始化db2");
        return new MongoProperties();
    }

}
