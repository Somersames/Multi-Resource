package xyz.somersames.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;



/**
 * @author szh
 * @create 2019-07-10 23:15
 **/

@Configuration
public class MongoDynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    private static final Logger logger = LoggerFactory.getLogger(MongoDynamicDataSourceRegister.class);

    @Override
    public void setEnvironment(Environment environment) {
        registerDefaultDataSource(environment);
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

    }

    private void registerDefaultDataSource(Environment environment){
        Binder binder = Binder.get(environment);
        MongoProperties mongoProperties = binder.bind("spring.data.mongodb", Bindable.of(MongoProperties.class)).get();
        if (mongoProperties != null) {
            logger.info("加载默认MongoDB成功");
        } else {
            //TODO 读取本配置文件
        }
    }

    private void registerCustomerDataSource(){

    }
}
