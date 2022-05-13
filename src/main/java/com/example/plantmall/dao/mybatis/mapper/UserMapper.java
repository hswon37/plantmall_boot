package com.example.plantmall.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.plantmall.domain.User;

@Mapper
public interface UserMapper {
	public List<User> selectList();
	
}
