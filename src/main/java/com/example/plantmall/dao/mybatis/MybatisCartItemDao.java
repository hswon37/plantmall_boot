package com.example.plantmall.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.plantmall.dao.CartItemDao;
import com.example.plantmall.dao.mybatis.mapper.CartItemMapper;
import com.example.plantmall.domain.CartItem;

@Repository
public class MybatisCartItemDao implements CartItemDao {
	@Autowired
	private CartItemMapper cartMapper;

	@Override
	public List<CartItem> getCartItemList(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return cartMapper.getCartItemList(userId);
	}

	@Override
	public CartItem getCartItemByProductId(String productId) {
		// TODO Auto-generated method stub
		return cartMapper.getCartItemByProductId(productId);
	}
	
	@Override
	public void insertCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartMapper.insertCartItem(cartItem);
	}

	@Override
	public void deleteCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartMapper.deleteCartItem(cartItem);
	}
	@Override
	public void updateCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartMapper.updateCartItem(cartItem);
	}

	@Override
	public Integer sumMoney(String userId) {
		// TODO Auto-generated method stub
		return cartMapper.sumMoney(userId);
	}

	@Override
	public void deleteCartItem(String userId, String productId) {
		// TODO Auto-generated method stub
		cartMapper.deleteCartItem(userId, productId);
	}
}
