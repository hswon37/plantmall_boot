package com.example.plantmall.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.plantmall.controller.SearchValueCommand;
import com.example.plantmall.domain.Product;
import com.example.plantmall.domain.Review;

public interface ProductDao {

	Product getProduct(String productId) throws DataAccessException;

	List<Product> getProductListByCategory(String categoryId) throws DataAccessException;

	List<Product> searchProductList(SearchValueCommand svc) throws DataAccessException;
	
	List<Product> showProductList(String productId) throws DataAccessException;

	List<Product> getAllProduct() throws DataAccessException;

	void insertProduct(Product product) throws DataAccessException;
	
	void updateProduct(Product product) throws DataAccessException;
	
	void deleteProduct(Product product) throws DataAccessException;
	
	// 제품과 리뷰 다 가져오기
	Product getProductAndReviewList(String productId) throws DataAccessException;
	// 제품 리뷰 정보
	List<Review> getReviewsByProductId(String productId) throws DataAccessException;
}