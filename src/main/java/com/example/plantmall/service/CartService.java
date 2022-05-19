package com.example.plantmall.service;

import java.util.List;

import com.example.plantmall.domain.CartItem;

public interface CartService {
	List<CartItem> getCartItemList(String userId);
	void insertCartItem(CartItem cartItem);
	void deleteCartItem(String productId);
	void deleteCartItemAll(String userId);
	void updateCartItem(CartItem cartItem);
	int sumMoney(String userId);
}
