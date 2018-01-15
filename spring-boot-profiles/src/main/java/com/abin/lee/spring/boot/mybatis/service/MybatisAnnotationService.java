package com.abin.lee.spring.boot.mybatis.service;

import com.abin.lee.spring.boot.mybatis.model.UserEntity;

import java.util.List;

/**
 * Created by abin on 2018/1/15 10:55.
 * spring-boot-start2
 * com.abin.lee.spring.boot.mybatis.service
 */
public interface MybatisAnnotationService {


    void insert(String userName, String passWord, String userSex, String nickName);


    void delete(Integer id);


    void update(Integer id, String userName,String passWord,String userSex,String nickName);


    UserEntity findById(Integer id);


    List<UserEntity> findAll();


}
