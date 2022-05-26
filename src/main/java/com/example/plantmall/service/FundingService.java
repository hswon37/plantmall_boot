package com.example.plantmall.service;

import java.util.List;

import com.example.plantmall.domain.Funding;

public interface FundingService {
	List<Funding> getAllFundingList();
	Funding getFunding(String id);
	void insertFunding(Funding funding);
	

}
