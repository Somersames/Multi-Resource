package com.somersames.config.mysql;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author szh
 * @create 2018-12-10 23:55
 **/
@Configuration
public class MysqlMultiProperties {

    @Bean("mysql1")
    @Primary
    @Qualifier("mysql1")
    @ConfigurationProperties("spring.datasource.mysql1")
    public DataSource mysql1Source(){
        return DataSourceBuilder.create().build();
    }

    @Bean("mysql2")
    @Primary
    @Qualifier("mysql2")
    @ConfigurationProperties("spring.datasource.mysql2")
    public DataSource mysql2Source(){
        return DataSourceBuilder.create().build();
//        return new DruidDataSource();
    }
}
