package com.example.plantmall.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class EnqComm {
	private int enquiryCommId;
	private int enquiryId;
	private String userId;
	private String enqComm;
}
