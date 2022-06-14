package com.example.plantmall.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@SuppressWarnings("serial")
@Getter @Setter @ToString
public class Funding implements Serializable{

	private String fundingId;
	private String productInformation;
	private String productId;
	private String sellerId;
	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateAt;
	private String p_name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date openDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date closeDate;
	private int targetQuantity;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deliveryDate;
	private int orderNum;
	
	
}
