package com.somersames.config.mysql;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author szh
 * @create 2018-12-10 23:55
 **/
@Slf4j
@Configuration
public class MysqlMultiProperties {

    @Bean("mysql1")
    @ConfigurationProperties("spring.datasource.mysql1")
    public DataSource mysql1Source(){
        log.info("正在初始化Mysql_DB1");
        return DataSourceBuilder.create().build();
    }

    @Bean("mysql2")
    @ConfigurationProperties("spring.datasource.mysql2")
    public DataSource mysql2Source(){
        log.info("正在初始化Mysql_DB2");
        return DataSourceBuilder.create().build();
    }
}
