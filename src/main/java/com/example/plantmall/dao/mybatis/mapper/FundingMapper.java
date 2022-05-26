package com.example.plantmall.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.plantmall.domain.Funding;
@Mapper
public interface FundingMapper {

	List<Funding> getAllFundingList();
	Funding getFundingById(String id);
	void insertFunding(Funding funding);
	
	
}
