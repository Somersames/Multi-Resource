package com.somersames.aopTest.aopconfig;

import com.somersames.aopTest.AopMain;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author szh
 * @create 2019-03-05 22:28
 **/
@Slf4j
@Component
@Aspect
@Order(-1)
public class AopConfig {


    @Around("execution(* com.somersames.aopTest.AopMain.*(..))")
    public Object a(ProceedingJoinPoint joinPoint) throws Throwable {
        AopMain o1 = (AopMain)joinPoint.getTarget();
        o1.setField1("adasadasdasdasd");
//        Field methodInvocationField = joinPoint.getClass().getDeclaredField("methodInvocation");
//        methodInvocationField.setAccessible(true);
//        ReflectiveMethodInvocation o = (ReflectiveMethodInvocation) methodInvocationField.get(joinPoint);
//
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
//        //需要移除final修饰的变量
//        modifiersField.setInt(mongoOperationsField,mongoOperationsField.getModifiers()&~Modifier.FINAL);
//        mongoOperationsField.set(singletonTarget, "ada");
        return joinPoint.proceed();
    }
}