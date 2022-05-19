package com.example.plantmall.controller;

import java.io.Serializable;

import com.example.plantmall.domain.Order;

@SuppressWarnings("serial")
public class OrderForm implements Serializable {
	
	private final Order order = new Order();
	public Order getOrder() {
		return order;
	}
}
