package com.example.plantmall.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.plantmall.domain.Product;

public interface ProductDao {

	Product getProduct(String productId) throws DataAccessException;

	List<Product> getProductListByCategory(String categoryId) throws DataAccessException;

	List<Product> searchProductList(String keywords) throws DataAccessException;
	
	List<Product> showProductList(String productId) throws DataAccessException;

	List<Product> getAllProduct() throws DataAccessException;

	void insertProduct(Product product) throws DataAccessException;
	
	void updateProduct(Product product) throws DataAccessException;
	
	void deleteProduct(Product product) throws DataAccessException;
}