package com.hasifyashin.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class ProjectConfig {
    @Value("${myDataSourceURL}")
    private String myDataSourceURL;
    @Value("${myDataSourceUser}")
    private String myDataSourceUser;
    @Value("${myDataSourcePwd}")
    private String myDataSourcePwd;
    @Bean
    @Primary
    public DataSource customDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(myDataSourceURL);
        hikariDataSource.setUsername(myDataSourceUser);
        hikariDataSource.setPassword(myDataSourcePwd);
        hikariDataSource.setMaximumPoolSize(10);
        return hikariDataSource;
    }
}
