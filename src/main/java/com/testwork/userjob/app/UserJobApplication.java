package com.testwork.userjob.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.testwork.userjob")
@EnableJpaRepositories(basePackages = "com.testwork.userjob.repository")
@EntityScan(basePackages = "com.testwork.userjob.model")
public class UserJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserJobApplication.class, args);
    }

}
