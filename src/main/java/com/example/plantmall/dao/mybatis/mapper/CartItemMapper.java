package com.example.plantmall.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.plantmall.domain.CartItem;

@Mapper
public interface CartItemMapper {
	List<CartItem> getCartItemList(String userId);
	void insertCartItem(CartItem cart);
	void deleteCartItem(String productId);
	void deleteCartItemAll(String userId);
	void updateCartItem(CartItem cartItem);
	int sumMoney(String userId);
}
