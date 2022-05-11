package com.example.plantmall.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@SuppressWarnings("serial")
public class CartItem implements Serializable {
	private Product product;
	private int quantity;
	
	public double getTotalPrice() {
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
	
	public void decreaseQuantity() {
	    quantity--;
	}
}
