package com.example.plantmall.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter @Setter 
public class Item implements Serializable{
	
	private String itemId;
	private Product product;
	private String productItd;
	private int quantity;
	private int listPrice;
	private int unitPrice;
	private String supplierId;
	
}