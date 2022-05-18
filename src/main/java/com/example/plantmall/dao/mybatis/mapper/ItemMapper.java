package com.example.plantmall.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.plantmall.domain.Item;

@Mapper
public interface ItemMapper {
	
	List<Item> getItemListByProduct(String productId);
	Item getItem(String itemId);
}
