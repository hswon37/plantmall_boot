package com.example.plantmall.domain;
import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@SuppressWarnings("serial")
public class LineItem implements Serializable {
	
	private int orderId;
	private int lineNumber;
	private int quantity;
	private String productId;
	private double unitPrice;
	  
	public LineItem(int lineNumber, CartItem cartItem) {
		this.lineNumber = lineNumber;
	    this.quantity = cartItem.getQuantity();
	    this.productId = cartItem.getProduct().getProductId();
	    this.unitPrice = cartItem.getProduct().getPrice();
	}
	
	public double getTotalPrice() {
		return this.unitPrice * this.quantity;
	}
}
