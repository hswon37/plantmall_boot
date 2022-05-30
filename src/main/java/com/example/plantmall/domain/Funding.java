package com.example.plantmall.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter @Setter
public class Funding {

	private String fundingId;
	private String categoryId;
	private Date calendar;
	private String productInformation;
	private String productId;
	private String title;
	private Date createAt;
	private Date updateAt;
	private String productImg;
	
	private List <Product> productList = new ArrayList<Product>();
	
}
