package com.abin.lee.spring.boot.mybatis.service.impl;

import com.abin.lee.spring.boot.mybatis.enums.UserSexEnum;
import com.abin.lee.spring.boot.mybatis.mapper.test1.User1Mapper;
import com.abin.lee.spring.boot.mybatis.model.UserEntity;
import com.abin.lee.spring.boot.mybatis.service.MybatisAnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by abin on 2018/1/15 10:55.
 * spring-boot-start2
 * com.abin.lee.spring.boot.mybatis.service.impl
 */
@Service
public class MybatisAnnotationServiceImpl implements MybatisAnnotationService {

    @Autowired
    User1Mapper userMapper;

    @Override
    public void insert(String userName, String passWord, String userSex, String nickName) {
        UserEntity model = new UserEntity();
//        model.setId(id.longValue());
        model.setUserName(userName);
        model.setNickName(nickName);
        model.setPassWord(passWord);
        UserSexEnum userSexEnum = StringUtils.hasText("MAN") ? UserSexEnum.MAN : UserSexEnum.WOMAN;
        model.setUserSex(userSexEnum);
        this.userMapper.insert(model);
    }

    @Override
    public void delete(Integer id) {
        this.userMapper.delete(id.longValue());
    }

    @Override
    public void update(Integer id, String userName, String passWord, String userSex, String nickName) {
        UserEntity model = new UserEntity();
        model.setId(id.longValue());
        model.setUserName(userName);
        model.setNickName(nickName);
        model.setPassWord(passWord);
        UserSexEnum userSexEnum = StringUtils.hasText("MAN") ? UserSexEnum.MAN : UserSexEnum.WOMAN;
        model.setUserSex(userSexEnum);
        this.userMapper.update(model);
    }

    @Override
    public UserEntity findById(Integer id) {
        return this.userMapper.getOne(id.longValue());
    }

    @Override
    public List<UserEntity> findAll() {
        return this.userMapper.getAll();
    }
}
