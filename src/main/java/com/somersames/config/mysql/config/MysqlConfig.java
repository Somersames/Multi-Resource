package com.somersames.config.mysql.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author szh
 * @create 2019-01-05 15:30
 **/
@Configuration
public class MysqlConfig {

    @Autowired
    @Qualifier("mysql1")
    DataSource mysql1;


    @Autowired
    @Qualifier("mysql2")
    DataSource mysql2;

    @Bean
    @Primary
    public DataSourceRouter generateRouter(){
        DataSourceRouter router =new DataSourceRouter();
        Map<Object,Object> targetMap = new HashMap<Object, Object>();
        targetMap.put("mysql1",mysql1);
        targetMap.put("mysql2",mysql2);
        router.setTargetDataSources(targetMap);
        router.setDefaultTargetDataSource(mysql1);
        router.afterPropertiesSet();
        return router;
    }

}
