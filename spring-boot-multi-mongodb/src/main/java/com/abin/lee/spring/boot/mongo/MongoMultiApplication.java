package com.abin.lee.spring.boot.mongo;

import com.abin.lee.spring.boot.mongo.config.props.MultipleMongoProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by abin on 2018/1/16 17:30.
 * spring-boot-start2
 * com.abin.lee.spring.boot.mongo
 */
@EnableConfigurationProperties(MultipleMongoProperties.class)
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class MongoMultiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoMultiApplication.class, args);
    }

}
