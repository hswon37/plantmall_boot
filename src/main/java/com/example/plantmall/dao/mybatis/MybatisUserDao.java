package com.example.plantmall.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.plantmall.dao.UserDao;
import com.example.plantmall.dao.mybatis.mapper.UserMapper;
import com.example.plantmall.domain.User;
@Repository
public class MybatisUserDao implements UserDao{

	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUser(String username, String password) {
		return userMapper.getAccountByUsernameAndPassword(username, password);
	}

	@Override
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}
}
