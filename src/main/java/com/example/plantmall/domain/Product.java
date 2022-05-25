package com.example.plantmall.domain;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter @Setter
@SuppressWarnings("serial")
public class Product implements Serializable {
	private String productId;
	private String categoryId;
	private String userId;
	private String p_name;
	private String description;
	private int price;
	private String productImg;
}
