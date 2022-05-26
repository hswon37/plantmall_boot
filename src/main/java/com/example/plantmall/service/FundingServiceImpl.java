package com.example.plantmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.plantmall.dao.FundingDao;
import com.example.plantmall.domain.Funding;

public class FundingServiceImpl implements FundingService{

	@Autowired
	private FundingDao fundingDao;
	
	@Override
	public List<Funding> getAllFundingList() {
		return fundingDao.getAllFundingList();
	}

	@Override
	public Funding getFunding(String id) {
		return fundingDao.getFunding(id);
	}

	@Override
	public void insertFunding(Funding funding) {
		fundingDao.insertFunding(funding);
	}

}
