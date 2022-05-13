package com.example.plantmall.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class User {
	private String userId;
	private String userName;
	private String password;
	private String email;
	private String phone;
	private String zipcode;
	private String address;
	
	private List<Review> reviewList = new ArrayList<Review>();
	private List<Enquiry> enquiryList = new ArrayList<Enquiry>();
	private List<EnquiryComment> enquiryCommList = new ArrayList<EnquiryComment>();
}
