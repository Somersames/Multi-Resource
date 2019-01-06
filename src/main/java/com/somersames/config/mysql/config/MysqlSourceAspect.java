package com.somersames.config.mysql.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.MapperMethod;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.lang.reflect.Method;

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
