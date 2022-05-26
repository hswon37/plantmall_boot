package com.example.plantmall.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter @Setter
public class Product implements Serializable{
	private String productId;
	private String categoryId;
	private String userId;
	private String p_name;
	private String description;
	private int price;
	private String productImg;
}
