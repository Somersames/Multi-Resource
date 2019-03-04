package com.somersames.config.mongo.config;

import com.somersames.config.mongo.db1.DB1Template;
import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.springframework.web.context.request.RequestAttributes.SCOPE_REQUEST;

/**
 * @author szh
 * @create 2019-03-04 23:12
 **/
@Slf4j
@Component
@Aspect
@Order(-1)
public class MongoAspect implements ApplicationContextAware {

    private ApplicationContext applicationContext;


    @Around("execution(* com.somersames.config.mongo.db2.DB2Repository.*(..))")
    public Object doSwitch(ProceedingJoinPoint joinPoint) throws Throwable {
////        // 拿到我们需要的tenant
////        String tenant = (String) RequestContextHolder.currentRequestAttributes().getAttribute("tenant", SCOPE_REQUEST);
////        tenant = tenant == null ? "test" : tenant;
//
        // 通过反射获取到target
        Field methodInvocationField = joinPoint.getClass().getDeclaredField("methodInvocation");
        methodInvocationField.setAccessible(true);
        ReflectiveMethodInvocation o = (ReflectiveMethodInvocation) methodInvocationField.get(joinPoint);

        Field targetField = o.getClass().getDeclaredField("target");
        targetField.setAccessible(true);
        Object target = targetField.get(o);

        // 获得SimpleMongoRepository，并往里面填入值
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        Object singletonTarget = AopProxyUtils.getSingletonTarget(target);
        Field mongoOperationsField = singletonTarget.getClass().getDeclaredField("mongoOperations");
        mongoOperationsField.setAccessible(true);
        //需要移除final修饰的变量
        modifiersField.setInt(mongoOperationsField,mongoOperationsField.getModifiers()&~Modifier.FINAL);
        mongoOperationsField.set(singletonTarget, applicationContext.getBean("mongoDB1"));
        return joinPoint.proceed();
    }


    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
