//package com.somersames.config.mysql.config;
//
//import com.somersames.config.mysql.MysqlMultiProperties;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.beans.MutablePropertyValues;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.support.BeanDefinitionRegistry;
//import org.springframework.beans.factory.support.GenericBeanDefinition;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.annotation.Order;
//import org.springframework.core.env.Environment;
//import org.springframework.core.type.AnnotationMetadata;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author szh
// * @create 2019-01-05 19:24
// **/
//@Slf4j
//@Order(99)
//public class DataSoouceRegister implements ImportBeanDefinitionRegistrar ,EnvironmentAware {
//
//    @Autowired
//    @Qualifier("mysql1")
//    DataSource mysql1;
//
//
//    @Autowired
//    @Qualifier("mysql2")
//    DataSource mysql2;
//
////    @ConfigurationProperties("spring.datasource.mysql1")
////    @Bean("mysql1")
////    @Primary
////    public DataSource mysql1Source(){
////        log.info("正在初始化Mysql_DB1");
////        return DataSourceBuilder.create().build();
////    }
////
////    @ConfigurationProperties("spring.datasource.mysql2")
////    @Bean("mysql2")
////    public DataSource mysql2Source(){
////        log.info("正在初始化Mysql_DB2");
////        return DataSourceBuilder.create().build();
////    }
//
//    @Override
////    @DependsOn("mysql1")
//    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
//        System.out.println(("多数据源注册开始"));
//        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
////        targetDataSources.put("mysql1",mysql1Source());
////        targetDataSources.put("mysql2",mysql2Source());
////        DataSource mysql1 = mysql1Source();
////        DataSource mysql2 = mysql2Source();
////        new MysqlMultiProperties();
//        targetDataSources.put("mysql1",mysql1);
////        targetDataSources.put("mysql2",mysql2);
//        DataSourceRouter.setDataSource("mysql1");
////        DataSourceRouter.setDataSource("mysql2");
//        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
//        beanDefinition.setBeanClass(DataSourceRouter.class);
//        beanDefinition.setSynthetic(true);
//        MutablePropertyValues mpv = beanDefinition.getPropertyValues();
//        mpv.addPropertyValue("defaultTargetDataSource",mysql1);
//        mpv.addPropertyValue("targetDataSources", targetDataSources);
//        beanDefinitionRegistry.registerBeanDefinition("dataSourceRouter", beanDefinition);
//    }
//
//    @Override
//    public void setEnvironment(Environment environment) {
//        System.out.println("JAVA_HOME:" + environment.getProperty("JAVA_HOME"));
//    }
////
////    @Primary
////    @ConfigurationProperties("spring.datasource.mysql1")
////    public DataSource mysql1Source(){
////        log.info("正在初始化Mysql_DB1");
////        return DataSourceBuilder.create().build();
////    }
////
////    @ConfigurationProperties("spring.datasource.mysql2")
////    public DataSource mysql2Source(){
////        log.info("正在初始化Mysql_DB2");
////        return DataSourceBuilder.create().build();
////    }
//}
