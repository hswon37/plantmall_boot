package com.example.plantmall.service;

import java.util.List;

import com.example.plantmall.domain.Category;
import com.example.plantmall.domain.Enquiry;
import com.example.plantmall.domain.Product;
import com.example.plantmall.domain.Review;
import com.example.plantmall.controller.SearchValueCommand;

public interface ProductService {

	public Product getProduct(String productId);
	
	public List<Product> getProductHaveLineItem(String productId);
	
	public Category getCategory(String categoryId);
	
	public List<Category> getCategoryList();

	public List<Product> getProductListByCategory(String categoryId);
	
	public List<Product> getAllProduct();
	
	public List<Product> searchProductList(SearchValueCommand svc);
	
	public List<Product> showProductList(String productId);
	
	public List<Product> getProductListforUser(String userId);

	public void insertProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(Product product);

	public void deleteContentHaveProduct(Product product);

	// 제품 + 리뷰리스트
	public Product getProductAndReviewEnquiry(String productId);
		
	public List<Review> getReviewsByProductId(String productId);
	
	public List<Enquiry> getEnquiryListByProductId(String productId);

}
