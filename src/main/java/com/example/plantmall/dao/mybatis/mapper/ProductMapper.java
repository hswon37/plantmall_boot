package com.example.plantmall.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.plantmall.domain.Product;

@Mapper
public interface ProductMapper {

	List<Product> getProductListByCategory(String categoryId);
	
	Product getProduct(String productId);
	
	List<Product> searchProductList(String keywords);

}