package com.example.plantmall.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Order {
	private int orderId;
	private String userName;
	private String phoneNumber;
	private Date orderDate;
	private String shipAddress;
	private String billAddress;
	private int totalPrice;
	private String creditCard;
	private String expiryDate;
	private String cardType;
	private String locale;
	private String status;
	private List<LineItem> lineItems = new ArrayList<LineItem>();
	
	public void initOrder(User user, Cart cart) {
		userName = user.getUserName();
		phoneNumber = user.getPhone();
		orderDate = new Date();
		
		shipAddress = user.getAddress();
		billAddress = user.getAddress();
		
		totalPrice = cart.getSubTotal();
		
		creditCard = "";
		expiryDate = "";
		cardType = "";
		locale = "";
	    status = "";
	    
	    Iterator<CartItem> i = cart.getAllCartItems();
	    while (i.hasNext()) {
	    	CartItem cartItem = (CartItem) i.next();
	        addLineItem(cartItem);
	    }
	    
	}
	
	public void addLineItem(CartItem cartItem) {
	    LineItem lineItem = new LineItem(lineItems.size() + 1, cartItem);
	    addLineItem(lineItem);
	 }

	 public void addLineItem(LineItem lineItem) {
	    lineItems.add(lineItem);
	 }
}
