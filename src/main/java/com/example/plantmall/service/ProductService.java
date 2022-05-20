package com.example.plantmall.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.plantmall.dao.CategoryDao;
import com.example.plantmall.dao.ProductDao;
import com.example.plantmall.domain.Category;
import com.example.plantmall.domain.Product;

@Service
@Transactional
public class ProductService {
	@Autowired   
	private CategoryDao mybatisCategoryDao;	

	@Autowired  
	private ProductDao productDao;
	
	public Category getCategory(String categoryId) {
		Category category = null;
		category = mybatisCategoryDao.getCategory(categoryId);
		
		return category;
	}

	public List<Product> getProductListByCategory(String categoryId) {
		return productDao.getProductListByCategory(categoryId);
	}

	public List<Product> searchProductList(String keywords) {
		return productDao.searchProductList(keywords);
	}

	public Product getProduct(String productId) {
		return productDao.getProduct(productId);
	}
}
