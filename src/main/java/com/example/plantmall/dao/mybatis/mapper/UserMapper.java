package com.example.plantmall.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.plantmall.domain.User;

@Mapper
public interface UserMapper {

	User getUserByEmail(String email);
	User getUserByEmailAndPassword(String email, String password);
	void insertUser(User user);
	void updateUser(User user);
	
	
}
