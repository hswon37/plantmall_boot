package com.example.plantmall.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Enquiry {
	private int enquiryId;
	private String productId;
	private String userId;
	private String enqTitle;
	private String enqContent;
	private Date enquiryDate;
}
