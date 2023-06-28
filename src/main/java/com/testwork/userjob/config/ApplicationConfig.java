package com.testwork.userjob.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfig {

//    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }

}
