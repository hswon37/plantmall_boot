package com.example.plantmall.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Order {
	private int orderId;
	private String userId;
	private String userName;
	private String phoneNumber;
	private Date orderDate;
	private String shipAddress;
	private int totalPrice;
	@NotEmpty
	private String creditCard;
	@NotEmpty
	private String expiryDate;
	@NotEmpty
	private String cardType;
	private List<LineItem> lineItems = new ArrayList<LineItem>();
	
	public void initOrder(User user, List<LineItem> lineItems) {
		userId = user.getUserId();
		userName = user.getUserName();
		phoneNumber = user.getPhone();
		orderDate = new Date();
		
		shipAddress = user.getAddress();
		
		totalPrice = getToTalPrice(lineItems);
		
		creditCard = "";
		expiryDate = "";
		cardType = "";
  
	    this.lineItems = lineItems;
	}
	
	public void addLineItem(CartItem cartItem) {
	    LineItem lineItem = new LineItem(lineItems.size(), cartItem);
	    addLineItem(lineItem);
	 }

	 public void addLineItem(LineItem lineItem) {
	    lineItems.add(lineItem);
	 }
	 
	 public int getToTalPrice(List<LineItem> lineItems) {
		 int sum = 0;
		 for (LineItem line : lineItems) {
			 sum += line.getTotalPrice();
		 }
		 return sum;
	 }
}
