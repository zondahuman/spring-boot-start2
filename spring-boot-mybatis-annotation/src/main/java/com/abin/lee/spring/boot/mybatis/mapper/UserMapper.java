package com.abin.lee.spring.boot.mybatis.mapper;

/**
 * Created by abin on 2018/1/12 18:03.
 * spring-boot-start2
 * com.abin.lee.spring.boot.mybatis.mapper
 */

import com.abin.lee.spring.boot.mybatis.enums.UserSexEnum;
import com.abin.lee.spring.boot.mybatis.model.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface UserMapper {

    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<UserEntity> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    UserEntity getOne(Long id);

    @Insert("INSERT INTO users(userName,passWord,user_sex,nick_name) VALUES(#{userName}, #{passWord}, #{userSex}, #{nickName})")
    void insert(UserEntity user);

    @Update("UPDATE users SET userName=#{userName},passWord=#{passWord}, user_sex=#{userSex}, nick_name=#{nickName} WHERE id =#{id}")
    void update(UserEntity user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);

}