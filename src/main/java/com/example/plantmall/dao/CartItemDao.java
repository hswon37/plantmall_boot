package com.example.plantmall.dao;

import java.util.List;

import com.example.plantmall.domain.CartItem;

public interface CartItemDao {
	List<CartItem> getCartItemList(String userId);
	void insertCartItem(CartItem CartItem);
	void deleteCartItem(CartItem cartItem);
	void updateCartItem(CartItem CartItem);
	Integer sumMoney(String userId);
}
