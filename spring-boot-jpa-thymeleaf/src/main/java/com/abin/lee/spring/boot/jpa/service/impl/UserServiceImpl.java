package com.abin.lee.spring.boot.jpa.service.impl;

/**
 * Created by abin on 2018/1/15 19:48.
 * spring-boot-start2
 * com.abin.lee.spring.boot.jpa.service.impl
 */
import com.abin.lee.spring.boot.jpa.model.User;
import com.abin.lee.spring.boot.jpa.repository.UserRepository;
import com.abin.lee.spring.boot.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }
}
