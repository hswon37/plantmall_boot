package com.example.plantmall.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.plantmall.domain.Item;

public interface ItemDao {
	
	List<Item> getItemListByProduct(String productId) throws DataAccessException;
	Item getItem(String itemId) throws DataAccessException;
	
}
