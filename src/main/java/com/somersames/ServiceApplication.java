package com.somersames;

import com.somersames.config.mysql.config.DataSourceRouter;
import com.somersames.config.mysql.config.MysqlConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author szh
 * @create 2018-12-09 23:25
 **/
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@SpringBootApplication
@MapperScan(basePackages = "com.somersames.dao")
@Import({MysqlConfig.class})
public class ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class);
    }
}
