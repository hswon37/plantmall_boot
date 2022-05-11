package com.example.plantmall.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	private String userId;
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
		userId = user.getUserId();
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
