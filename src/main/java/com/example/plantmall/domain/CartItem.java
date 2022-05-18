package com.example.plantmall.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@SuppressWarnings("serial")
public class CartItem implements Serializable {
	private Item item;
	private int quantity;
	
	public double getTotalPrice() {
		if (item != null) {
			return item.getListPrice() * quantity;
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
