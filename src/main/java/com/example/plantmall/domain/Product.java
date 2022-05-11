package com.example.plantmall.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {
	private String productId;
	private String categoryId;
	private String userId;
	private String p_name;
	private String description;
	private int price;
	private String productImg;
}
