package com.example.plantmall.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter @Setter
public class Funding {

	private String fundingId;
	private String productInformation;
	private String productId;
	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateAt;
	private String productImg;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date openDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date closeDate;
	private int targetQuantity;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deliveryDate;
	
	
}
