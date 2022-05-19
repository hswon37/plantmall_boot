package com.example.plantmall.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.plantmall.dao.mybatis.mapper.CartItemMapper;
import com.example.plantmall.domain.CartItem;

@Repository
public class MybatisCartItemDao implements CartItemMapper {
	@Autowired
	private CartItemMapper cartMapper;

	@Override
	public List<CartItem> getCartItemList(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return cartMapper.getCartItemList(userId);
	}

	@Override
	public void insertCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartMapper.insertCartItem(cartItem);
	}

	@Override
	public void deleteCartItem(String productId) {
		// TODO Auto-generated method stub
		cartMapper.deleteCartItem(productId);
	}

	@Override
	public void deleteCartItemAll(String userId) {
		// TODO Auto-generated method stub
		cartMapper.deleteCartItemAll(userId);
	}

	@Override
	public void updateCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartMapper.updateCartItem(cartItem);
	}

	@Override
	public int sumMoney(String userId) {
		// TODO Auto-generated method stub
		return cartMapper.sumMoney(userId);
	}
}
