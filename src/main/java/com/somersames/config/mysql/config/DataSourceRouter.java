package com.somersames.config.mysql.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author szh
 * @create 2019-01-05 18:44
 **/
@Slf4j
public class DataSourceRouter extends AbstractRoutingDataSource {


    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }

    public static void setDataSource(String dataSource) {
        contextHolder.set(dataSource);
    }

    public static String getDataSource() {
        return contextHolder.get();
    }

}
