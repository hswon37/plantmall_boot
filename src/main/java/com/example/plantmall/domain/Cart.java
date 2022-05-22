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

	private String userId;
	private final Map<String, CartItem> itemMap = Collections.synchronizedMap(new HashMap<String, CartItem>());
	private final PagedListHolder<CartItem> itemList = new PagedListHolder<CartItem>();

	public Iterator<CartItem> getAllCartItems() {
		return itemList.getSource().iterator();
	}

	public PagedListHolder<CartItem> getCartItemList() {
		return itemList;
	}

	public int getNumberOfItems() {
		return itemList.getSource().size();
	}

	public boolean containsItemId(String itemId) {
		return itemMap.containsKey(itemId);
	}

	public void addItem(Item item, boolean isInStock) {
		CartItem cartItem = itemMap.get(item.getItemId());
		if (cartItem == null) {
			cartItem = new CartItem();
			cartItem.setItem(item);
			cartItem.setQuantity(0);
			itemMap.put(item.getItemId(), cartItem);
			itemList.getSource().add(cartItem);
		}
		cartItem.incrementQuantity();
	}

	public Item removeCartItemById(String ProdutId) {
		CartItem cartItem = itemMap.remove(ProdutId);
		if (cartItem == null) {
			return null;
		} else {
			itemList.getSource().remove(cartItem);
			return cartItem.getItem();
		}
	}

	public void incrementQuantityByItemId(String ProdutId) {
		CartItem cartItem = itemMap.get(ProdutId);
		cartItem.incrementQuantity();
	}

	public void setQuantityByItemId(String ProdutId, int quantity) {
		CartItem cartItem = itemMap.get(ProdutId);
		cartItem.setQuantity(quantity);
	}

	public int getSubTotal() {
		int subTotal = 0;
		Iterator<CartItem> items = getAllCartItems();
		while (items.hasNext()) {
			CartItem cartItem = (CartItem) items.next();
			Item Item = cartItem.getItem();
			int listPrice = Item.getListPrice();
			int quantity = cartItem.getQuantity();
			subTotal += listPrice * quantity;
		}
		return subTotal;
	}

}
