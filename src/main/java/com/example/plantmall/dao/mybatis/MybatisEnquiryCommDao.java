package com.example.plantmall.dao.mybatis;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.plantmall.dao.EnquiryCommDao;
import com.example.plantmall.domain.EnqComm;

@Repository
public class MybatisEnquiryCommDao implements EnquiryCommDao{

	@Override
	public EnqComm getEnqCommByEuquiryId(int enquiryid) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnqComm getEnqCommByEnquiryCommId(int enqCommId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
