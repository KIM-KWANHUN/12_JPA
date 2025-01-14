package com.ohgiraffers.chap100crudtest.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ohgiraffers.chap100crudtest")
@EntityScan(basePackages = "com.ohgiraffers.chap100crudtest")
public class Chap100CrudTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap100CrudTestApplication.class, args);
    }

}
