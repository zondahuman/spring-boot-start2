package com.abin.lee.spring.boot.mybatis.test;

/**
 * Created by abin on 2018/1/12 18:38.
 * spring-boot-start2
 * com.abin.lee.spring.boot.mybatis.test
 */
import java.util.List;

import com.abin.lee.spring.boot.mybatis.enums.UserSexEnum;
import com.abin.lee.spring.boot.mybatis.mapper.test1.User1Mapper;
import com.abin.lee.spring.boot.mybatis.model.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    User1Mapper UserMapper;

    @Test
    public void testInsert() throws Exception {
        UserMapper.insert(new UserEntity("aa", "a123456", UserSexEnum.MAN));
        UserMapper.insert(new UserEntity("bb", "b123456", UserSexEnum.WOMAN));
        UserMapper.insert(new UserEntity("cc", "b123456", UserSexEnum.WOMAN));

        Assert.assertEquals(3, UserMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<UserEntity> users = UserMapper.getAll();
        if(users==null || users.size()==0){
            System.out.println("is null");
        }else{
            System.out.println(users.toString());
        }
    }


    @Test
    public void testUpdate() throws Exception {
        UserEntity user = UserMapper.getOne(6l);
        System.out.println(user.toString());
        user.setNickName("neo");
        UserMapper.update(user);
        Assert.assertTrue(("neo".equals(UserMapper.getOne(6l).getNickName())));
    }

}