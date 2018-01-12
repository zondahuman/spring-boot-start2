package com.abin.lee.spring.boot.mybatis.test;

/**
 * Created by abin on 2018/1/12 18:38.
 * spring-boot-start2
 * com.abin.lee.spring.boot.mybatis.test
 */
import com.abin.lee.spring.boot.mybatis.enums.UserSexEnum;
import com.abin.lee.spring.boot.mybatis.model.UserEntity;
import net.minidev.json.JSONUtil;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.abin.lee.spring.boot.mybatis.mapper.UserMapper;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper UserMapper;

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
        System.out.println("---------------------------start------------------------: ");
        System.out.println(JSONObject.valueToString(users));
        System.out.println("---------------------------end------------------------: ");
    }


    @Test
    public void testUpdate() throws Exception {
        UserEntity user = UserMapper.getOne(3l);
        System.out.println(user.toString());
        user.setNickName("neo");
        UserMapper.update(user);
        Assert.assertTrue(("neo".equals(UserMapper.getOne(3l).getNickName())));
    }

}