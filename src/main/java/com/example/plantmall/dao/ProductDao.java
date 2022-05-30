package com.example.plantmall.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.plantmall.domain.Product;
import com.example.plantmall.domain.Review;

public interface ProductDao {

	List<Product> getProductListByCategory(String categoryId) throws DataAccessException;

	List<Product> searchProductList(String keywords) throws DataAccessException;

	Product getProduct(String productId) throws DataAccessException;

	// 제품과 리뷰 다 가져오기
	Product getProductAndReviewList(String productId) throws DataAccessException;
	// 제품 리뷰 정보
	List<Review> getReviewsByProductId(String productId) throws DataAccessException;
}