package com.example.plantmall.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.plantmall.controller.SearchValueCommand;
import com.example.plantmall.domain.Product;

@Mapper
public interface ProductMapper {

	Product getProduct(String productId);
	
	List<Product> getProductListByCategory(String categoryId);
	
	List<Product> searchProductList(SearchValueCommand svc);
	
	List<Product> showProductList(String productId);
	
	List<Product> getAllProduct();

	void insertProduct(Product product);
	
	void updateProduct(Product product);
	
	void deleteProduct(Product product);
	
	// 리뷰를 담기 위한 mapper
	Product getProductAndReviews(String productId);
	List<Product> searchProductList(String keywords);
}