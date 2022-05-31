package com.example.plantmall.dao;

import org.springframework.dao.DataAccessException;

import com.example.plantmall.domain.EnqComm;

public interface EnquiryCommDao {
	EnqComm getEnqCommByEuquiryId(int enquiryid) throws DataAccessException;
	EnqComm getEnqCommByEnquiryCommId(int enqCommId) throws DataAccessException;
}