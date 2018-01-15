package com.abin.lee.spring.boot.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by abin on 2018/1/12 18:00.
 * spring-boot-start2
 * com.abin.lee.spring.boot.mybatis
 */
@SpringBootApplication
@MapperScan("com.abin.lee.spring.boot.mybatis.mapper")
public class MybatisAnnotationApplication {

    public static void main(String[] args) {

        SpringApplication.run(MybatisAnnotationApplication.class, args);

    }
}
