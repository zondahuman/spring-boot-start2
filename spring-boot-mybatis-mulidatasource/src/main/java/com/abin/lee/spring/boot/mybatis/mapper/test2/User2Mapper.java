package com.abin.lee.spring.boot.mybatis.mapper.test2;


import com.abin.lee.spring.boot.mybatis.model.UserEntity;

import java.util.List;

public interface User2Mapper {
	
	List<UserEntity> getAll();
	
	UserEntity getOne(Long id);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);

}