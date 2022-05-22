package com.example.plantmall.domain;
import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter 
@NoArgsConstructor
@SuppressWarnings("serial")
public class LineItem implements Serializable {
	
	private int orderId;
	private int lineNumber;
	private int quantity;
	private int unitPrice;
	private Item item;
	private String itemId;
	
	public LineItem(int lineNumber, CartItem cartItem) {
		this.lineNumber = lineNumber;
	    this.quantity = cartItem.getQuantity();
	    this.unitPrice = cartItem.getItem().getUnitPrice();
	    this.item = cartItem.getItem();
	    this.itemId = cartItem.getItem().getItemId();
	}
	
	public double getTotalPrice() {
		return this.unitPrice * this.quantity;
	}
}
