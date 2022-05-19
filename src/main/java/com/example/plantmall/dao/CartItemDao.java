package com.example.plantmall.dao;

import java.util.List;

import com.example.plantmall.domain.CartItem;

public interface CartItemDao {
	List<CartItem> getCartItemList(String userId);
	void insertCartItem(CartItem CartItem);
	void deleteCartItem(String productId);
	void deleteCartItemAll(String userId);
	void updateCartItem(CartItem CartItem);
	int sumMoney(String userId);
}
