package com.example.plantmall.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Review {
	private int reviewId;
	private String productId;
	private String userId;
	private String title;
	private String review;
	
}
