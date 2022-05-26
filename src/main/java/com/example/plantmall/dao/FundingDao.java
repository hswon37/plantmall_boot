package com.example.plantmall.dao;

import java.util.List;
import com.example.plantmall.domain.Funding;
public interface FundingDao {

	List<Funding> getAllFundingList();
	Funding getFunding(String id);
	void insertFunding(Funding funding);
}
