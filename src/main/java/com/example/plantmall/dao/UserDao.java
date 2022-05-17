package com.example.plantmall.dao;

import com.example.plantmall.domain.User;

public interface UserDao {

	User getUser(String username, String password);
	void insertUser(User user);
}
