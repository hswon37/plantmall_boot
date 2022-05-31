package com.example.plantmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.plantmall.dao.EnquiryDao;
import com.example.plantmall.domain.Enquiry;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private EnquiryDao enqDao;
	
	@Override
	public List<Enquiry> getEnquiryListByProductId(String productId) {
		// TODO Auto-generated method stub
		return enqDao.getEnquiryListByProductId(productId);
	}

	@Override
	public Enquiry getEnquiry(Enquiry enq) {
		// TODO Auto-generated method stub
		return enqDao.getEnquiry(enq);
	}

	@Override
	public Enquiry getEnquiryByEnquiryId(int enq) {
		// TODO Auto-generated method stub
		return enqDao.getEnquiryByEnquiryId(enq);
	}

	@Override
	public void insertEnquiry(Enquiry enq) {
		// TODO Auto-generated method stub
		enqDao.insertEnquiry(enq);
	}

	@Override
	public Enquiry updateEnquiry(Enquiry enq) {
		// TODO Auto-generated method stub
		return enqDao.updateEnquiry(enq);
	}

	@Override
	public void deleteEnquiry(int enq) {
		// TODO Auto-generated method stub
		enqDao.deleteEnquiry(enq);
	}

}
