package com.example.plantmall.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CartItem {
	private String userId;
	private String productId;
	private int quantity;
	private int unitPrice;
	private Product product;
	
	public int getTotalPrice() {
		if (product != null) {
			return product.getPrice() * quantity;
		}
		else {
			return 0;
		}
	}
	
	public void incrementQuantity() {
		quantity++;
	}
}
