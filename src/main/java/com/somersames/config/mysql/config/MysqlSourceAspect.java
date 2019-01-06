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

    /**
     * 切点: 所有配置 DataSource 注解的方法
     */
    @Pointcut("@annotation(com.somersames.config.mysql.config.UseDataSource)")
    public void dataSourcePointCut() {}


//    @Pointcut("execution(public * com.somersames.service.mysql..*.*(..))")
//    public void webLog(){}

    public MysqlSourceAspect() {
        System.out.println("-----------------------------------");
    }

    @Before("@annotation(useDataSource)")
    public void changeMysqlSource(UseDataSource useDataSource){
        System.out.println("----------------------------------1-");
//        String currentSource = useDataSource.name();
//        System.out.println("adasds"+currentSource);
//        DataSourceRouter.setDataSource(currentSource);
        // 通过判断 DataSource 中的值来判断当前方法应用哪个数据源
        System.out.println("adasdasdasasdas");
        DataSourceRouter.setDataSource(useDataSource.name());
    }
}
