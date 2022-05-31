package com.example.plantmall.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Getter @Setter
@AllArgsConstructor
@ToString
public class EnqComm implements Serializable {
	private int enquiryCommId;
	private int enquiryId;
	private String userId;	//판매자 아이디
	private String enqComm;
}
