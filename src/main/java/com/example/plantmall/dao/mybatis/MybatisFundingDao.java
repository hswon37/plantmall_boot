package com.example.plantmall.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.plantmall.dao.FundingDao;
import com.example.plantmall.dao.mybatis.mapper.FundingMapper;
import com.example.plantmall.domain.Funding;

@Repository
public class MybatisFundingDao implements FundingDao{

	@Autowired
	private FundingMapper fundingMapper;

	@Override
	public List<Funding> getAllFundingList() {
		return fundingMapper.getAllFundingList();
	}

	@Override
	public Funding getFunding(String id) {
		return fundingMapper.getFundingById(id);
	}

	@Override
	public void insertFunding(Funding funding) {
		fundingMapper.insertFunding(funding);
		
	}
	
	
	
	
}
