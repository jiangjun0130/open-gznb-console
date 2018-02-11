package com.gznb.open.service.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * druid数据源支持类
 *
 * Created by jj02 on 2017/3/15.
 */
@Configuration
public class DruidConfig {

    @ConditionalOnClass(DruidDataSource.class)
    @ConditionalOnProperty(name = "spring.datasource.type",
            havingValue = "com.alibaba.druid.pool.DruidDataSource",
            matchIfMissing = true)
    static class Druid extends DruidConfig{

        @Bean
        @ConfigurationProperties("spring.datasource.druid")
        public DruidDataSource dataSource(DataSourceProperties properties){
            DruidDataSource druidDataSource = (DruidDataSource) properties.initializeDataSourceBuilder()
                    .type(DruidDataSource.class).build();
            DatabaseDriver databaseDriver = DatabaseDriver.fromJdbcUrl(properties.determineUrl());
            String validationQuery = databaseDriver.getValidationQuery();
            if(validationQuery != null){
                druidDataSource.setValidationQuery(validationQuery);
            }
            return druidDataSource;
        }
    }
}
