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
	private Product product;
	private String productId;
	
	public LineItem(int lineNumber, CartItem cartItem) {
		this.lineNumber = lineNumber;
	    this.quantity = cartItem.getQuantity();
	    this.unitPrice = cartItem.getUnitPrice();
	    this.product = cartItem.getProduct();
	    this.productId = cartItem.getProduct().getProductId();
	}
	
	public int getTotalPrice() {
		return this.unitPrice * this.quantity;
	}
}
