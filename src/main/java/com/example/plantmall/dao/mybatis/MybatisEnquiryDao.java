package com.example.plantmall.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.plantmall.dao.EnquiryDao;
import com.example.plantmall.dao.mybatis.mapper.EnquiryMapper;
import com.example.plantmall.domain.Enquiry;

@Repository
public class MybatisEnquiryDao implements EnquiryDao{

	@Autowired
	private EnquiryMapper enqMapper;
	
	@Override
	public List<Enquiry> getEnquiryListByProductId(String productId) throws DataAccessException {
		// TODO Auto-generated method stub
		return enqMapper.getEnquiryListByProductId(productId);
	}

	@Override
	public Enquiry getEnquiry(Enquiry enq) throws DataAccessException {
		// TODO Auto-generated method stub
		return enqMapper.getEnquiry(enq);
	}

	@Override
	public Enquiry getEnquiryByEnquiryId(int enq) throws DataAccessException {
		// TODO Auto-generated method stub
		return enqMapper.getEnquiryByEnquiryId(enq);
	}

	@Override
	public void insertEnquiry(Enquiry enq) throws DataAccessException {
		// TODO Auto-generated method stub
		enqMapper.insertEnquiry(enq);
	}

	@Override
	public Enquiry updateEnquiry(Enquiry enq) throws DataAccessException {
		// TODO Auto-generated method stub
		return enqMapper.updateEnquiry(enq);
	}

	@Override
	public void deleteEnquiry(int enq) throws DataAccessException {
		// TODO Auto-generated method stub
		enqMapper.deleteEnquiry(enq);
	}

}
