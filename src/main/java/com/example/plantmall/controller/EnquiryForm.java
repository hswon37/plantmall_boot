package com.example.plantmall.controller;

import java.io.Serializable;

import com.example.plantmall.domain.Enquiry;

@SuppressWarnings("serial")
public class EnquiryForm implements Serializable{
	
	private final Enquiry enquiry = new Enquiry();
	public Enquiry getEnquiry() {
		return enquiry;
	}
}