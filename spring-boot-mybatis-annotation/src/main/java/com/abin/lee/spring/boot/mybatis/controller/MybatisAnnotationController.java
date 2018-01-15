package com.abin.lee.spring.boot.mybatis.controller;

import com.abin.lee.spring.boot.mybatis.enums.UserSexEnum;
import com.abin.lee.spring.boot.mybatis.model.UserEntity;
import com.abin.lee.spring.boot.mybatis.service.MybatisAnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by abin on 2018/1/12 18:01.
 * spring-boot-start2
 * com.abin.lee.spring.boot.mybatis.controller
 */
@RestController
public class MybatisAnnotationController {


    @Autowired
    MybatisAnnotationService mybatisAnnotationService;

    @RequestMapping(value = "/insert")
    public String insert(String userName, String passWord, String userSex, String nickName){
        String result = "FAILURE";
        try {
            this.mybatisAnnotationService.insert(userName, passWord, userSex, nickName);
            result = "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }



    @RequestMapping(value = "/delete")
    public String delete(Integer id){
        String result = "FAILURE";
        try {
            this.mybatisAnnotationService.delete(id);
            result = "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/update")
    public String update(Integer id, String userName, String passWord, String userSex, String nickName){
        String result = "FAILURE";
        try {
            this.mybatisAnnotationService.update(id, userName, passWord, userSex, nickName);
            result = "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping(value = "/findById")
    public UserEntity findById(Integer id){
        UserEntity userEntity = null;
        try {
            userEntity = this.mybatisAnnotationService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userEntity;
    }


    @RequestMapping(value = "/findAll")
    public List<UserEntity> findAll(){
        List<UserEntity> userEntityList = null;
        try {
            userEntityList = this.mybatisAnnotationService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userEntityList;
    }


}
