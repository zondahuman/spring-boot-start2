package com.abin.lee.spring.boot.mybatis.mapper;

/**
 * Created by abin on 2018/1/12 18:03.
 * spring-boot-start2
 * com.abin.lee.spring.boot.mybatis.mapper
 */

import com.abin.lee.spring.boot.mybatis.model.UserEntity;

import java.util.List;


public interface UserMapper {

    List<UserEntity> getAll();

    UserEntity getOne(Long id);

    void insert(UserEntity user);

    void update(UserEntity user);

    void delete(Long id);

}