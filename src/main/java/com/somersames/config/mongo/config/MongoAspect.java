package com.somersames.config.mongo.config;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.*;
import org.springframework.aop.support.AopUtils;
import org.springframework.aop.target.SingletonTargetSource;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

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
        return aopTest1(joinPoint);
//        aopTest2(joinPoint);
    }


    private Object aopTest1(ProceedingJoinPoint joinPoint) throws Throwable {
        //        // 通过反射获取到target
        Field methodInvocationField = joinPoint.getClass().getDeclaredField("methodInvocation");
        methodInvocationField.setAccessible(true);
        ReflectiveMethodInvocation o = (ReflectiveMethodInvocation) methodInvocationField.get(joinPoint);
        Field targetField = o.getClass().getDeclaredField("target");
        targetField.setAccessible(true);
        Object target = targetField.get(o);

//        // 获得SimpleMongoRepository，并往里面填入值
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


    private Object aopTest2(ProceedingJoinPoint joinPoint) throws Throwable {
        Field methodInvocationField = joinPoint.getClass().getDeclaredField("methodInvocation");
        methodInvocationField.setAccessible(true);
        ReflectiveMethodInvocation o = (ReflectiveMethodInvocation) methodInvocationField.get(joinPoint);
        Field h = o.getProxy().getClass().getSuperclass().getDeclaredField("h");
        h.setAccessible(true);
        AopProxy aopProxy = (AopProxy) h.get(o.getProxy());
        Field advised = aopProxy.getClass().getDeclaredField("advised");
        advised.setAccessible(true);
        Object o2 = advised.get(aopProxy);
        if (o2 instanceof Advised) {
            Object o1 = ((Advised) o2).getTargetSource().getTarget();
            Object o3 = AopProxyUtils.getSingletonTarget(o1);
            System.out.println(o3);
            Field mongoOperationsField = o3.getClass().getDeclaredField("mongoOperations");
            mongoOperationsField.setAccessible(true);
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            //需要移除final修饰的变量
            modifiersField.setInt(mongoOperationsField, mongoOperationsField.getModifiers() & ~Modifier.FINAL);
            mongoOperationsField.set(o3, applicationContext.getBean("mongoDB1"));
        }
        return joinPoint.proceed();
    }

    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
