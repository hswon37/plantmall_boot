package com.example.plantmall.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.plantmall.dao.ItemDao;
import com.example.plantmall.dao.mybatis.mapper.ItemMapper;
import com.example.plantmall.domain.Item;

@Repository
public class MybatisItemDao implements ItemDao {
	
	@Autowired
	private ItemMapper itemMapper;

	@Override
	public List<Item> getItemListByProduct(String productId) throws DataAccessException {
		// TODO Auto-generated method stub
		return itemMapper.getItemListByProduct(productId);
	}

	@Override
	public Item getItem(String itemId) throws DataAccessException {
		// TODO Auto-generated method stubs
		return itemMapper.getItem(itemId);
	}
	
}
