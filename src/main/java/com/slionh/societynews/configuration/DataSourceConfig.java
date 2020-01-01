package com.slionh.societynews.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/*
 * Create by s lion h on 2020-01-01
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "alidb")
    @Qualifier("ali")
    @ConfigurationProperties(prefix="spring.datasource.ali")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "tencentdb")
    @Qualifier("tencent")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.tencent")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }
}
