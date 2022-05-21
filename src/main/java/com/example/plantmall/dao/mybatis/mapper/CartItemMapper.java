package com.example.plantmall.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.plantmall.domain.CartItem;

@Mapper
public interface CartItemMapper {
	List<CartItem> getCartItemList(String userId);
	void insertCartItem(CartItem cartItem);
	void deleteCartItem(CartItem cartItem);
	void updateCartItem(CartItem cartItem);
	Integer sumMoney(String userId);
}
