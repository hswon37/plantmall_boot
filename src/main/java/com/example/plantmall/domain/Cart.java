package com.example.plantmall.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.support.PagedListHolder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SuppressWarnings("serial")
public class Cart implements Serializable {

	private final Map<String, CartItem> itemMap = Collections.synchronizedMap(new HashMap<String, CartItem>());
	private final PagedListHolder<CartItem> itemList = new PagedListHolder<CartItem>();

	public Iterator<CartItem> getAllCartItems() {
		return itemList.getSource().iterator();
	}

	public PagedListHolder<CartItem> getCartItemList() {
		return itemList;
	}

	public int getNumberOfCartItems() {
		return itemList.getSource().size();
	}

	public boolean containsCartItemId(String CartItemId) {
		return itemMap.containsKey(CartItemId);
	}

	public void addProduct(Product product, boolean isInStock) {
		CartItem cartItem = itemMap.get(product.getProductId());
		if (cartItem == null) {
			cartItem = new CartItem();
			cartItem.setQuantity(0);
			itemMap.put(product.getProductId(), cartItem);
			itemList.getSource().add(cartItem);
		}
		cartItem.incrementQuantity();
	}

	public Product removeCartItemById(String produtId) {
		CartItem cartItem = itemMap.remove(produtId);
		if (cartItem == null) {
			return null;
		} else {
			itemList.getSource().remove(cartItem);
			return cartItem.getProduct();
		}
	}
	
	public void incrementQuantityByItemId(String itemId) {
	    CartItem cartItem = itemMap.get(itemId);
	    cartItem.incrementQuantity();
	}

	public void setQuantityByItemId(String itemId, int quantity) {
	    CartItem cartItem = itemMap.get(itemId);
	    cartItem.setQuantity(quantity);
	}

	public int getSubTotal() {
	    int subTotal = 0;
	    Iterator<CartItem> items = getAllCartItems();
	    while (items.hasNext()) {
	      CartItem cartItem = (CartItem) items.next();
	      Product product = cartItem.getProduct();
	      int price = product.getPrice();
	      int quantity = cartItem.getQuantity();
	      subTotal += price * quantity;
	    }
	    return subTotal;
	}

}
