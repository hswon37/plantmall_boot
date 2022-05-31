package com.example.plantmall.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import com.example.plantmall.domain.EnqComm;

@Mapper
public interface EnquiryCommMapper {
	EnqComm getEnqCommByEuquiryId(int enquiryid) throws DataAccessException;
	EnqComm getEnqCommByEnquiryCommId(int enqCommId) throws DataAccessException;
}
