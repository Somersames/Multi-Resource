package com.somersames.config.redis.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author szh
 * @create 2019-03-07 0:12
 **/

@Slf4j
@Component
@Aspect
@Order(-1)
public class RedisAspect implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Around("execution(* com.somersames.service.redis.RedisService.*(..))")
    public void as(ProceedingJoinPoint joinPoint) throws Throwable {
// 通过反射获取到target
        Field methodInvocationField = joinPoint.getClass().getDeclaredField("methodInvocation");
        methodInvocationField.setAccessible(true);
        ReflectiveMethodInvocation o = (ReflectiveMethodInvocation) methodInvocationField.get(joinPoint);
        Field h = o.getProxy().getClass().getDeclaredField("CGLIB$CALLBACK_0");
        h.setAccessible(true);
        Object dynamicAdvisedInterceptor = h.get(o.getProxy());
        Field advised = dynamicAdvisedInterceptor.getClass().getDeclaredField("advised");
        advised.setAccessible(true);

        Object target = ((AdvisedSupport)advised.get(dynamicAdvisedInterceptor)).getTargetSource().getTarget();
        Object singletonTarget = AopProxyUtils.getSingletonTarget(dynamicAdvisedInterceptor);
        Field re = target.getClass().getDeclaredField("redisTemplate");
        re.setAccessible(true);
        Object reO = re.get(target);
        Field redisCon = reO.getClass().getDeclaredField("target");
        redisCon.setAccessible(true);
        redisCon.set(reO,applicationContext.getBean("redis2"));
        System.out.println(target.toString());
//        Field targetField = o.getClass().getDeclaredField("target");
//        targetField.setAccessible(true);
//        Object target = targetField.get(o);
//
//        // 获得SimpleMongoRepository，并往里面填入值
//        Field modifiersField = Field.class.getDeclaredField("modifiers");
//        modifiersField.setAccessible(true);
//        Object singletonTarget = AopProxyUtils.getSingletonTarget(target);
//        Field mongoOperationsField = singletonTarget.getClass().getDeclaredField("mongoOperations");
//        mongoOperationsField.setAccessible(true);
//        modifiersField.setInt(mongoOperationsField,mongoOperationsField.getModifiers()&~Modifier.FINAL);
//        mongoOperationsField.set(singletonTarget, applicationContext.getBean("redis2"));
        joinPoint.proceed();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}