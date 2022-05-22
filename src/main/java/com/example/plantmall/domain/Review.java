package com.example.plantmall.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Review {
	private int reviewId;
	private String productId;
	private String userId;
	private String reviewTitle;
	private String reviewContent;
	private Date reviewDate;
	
}
