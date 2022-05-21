package com.example.plantmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.plantmall.dao.CartItemDao;
import com.example.plantmall.domain.CartItem;


@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartItemDao cartItemDao;
	
	@Override
	public List<CartItem> getCartItemList(String userId) {
		// TODO Auto-generated method stub
		return cartItemDao.getCartItemList(userId);
	}

	@Override
	public void insertCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartItemDao.insertCartItem(cartItem);
	}

	@Override
	public void deleteCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartItemDao.deleteCartItem(cartItem);
	}

	@Override
	public void updateCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartItemDao.updateCartItem(cartItem);
	}

	@Override
	public Integer sumMoney(String userId) {
		// TODO Auto-generated method stub
		return cartItemDao.sumMoney(userId);
	}

}
