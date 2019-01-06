package com.somersames.config.mysql.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author szh
 * @create 2019-01-05 15:39
 **/
@Slf4j
@Component
@Aspect
@Order(-1)
public class MysqlSourceAspect {

    @Before("@annotation(useDataSource)")
    public void changeMysqlSource(UseDataSource useDataSource){
        DataSourceRouter.setDataSource(useDataSource.name());
    }
}
