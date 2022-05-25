package com.example.plantmall.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.plantmall.dao.CategoryDao;
import com.example.plantmall.dao.ProductDao;
import com.example.plantmall.domain.Category;
import com.example.plantmall.domain.Product;
//import com.example.plantmall.domain.User;

@Service
@Transactional
public class ProductService {
	@Autowired   
	private CategoryDao categoryDao;	

	@Autowired  
	private ProductDao productDao;
	
	public Product getProduct(String productId) {
		return productDao.getProduct(productId);
	}
	
	public Category getCategory(String categoryId) {
		Category category = null;
		category = categoryDao.getCategory(categoryId);
		
		return category;
	}

	public List<Product> getProductListByCategory(String categoryId) {
		return productDao.getProductListByCategory(categoryId);
	}

	public List<Product> getAllProduct() {
		return productDao.getAllProduct();
	}
	
	public List<Product> searchProductList(String keywords) {
		return productDao.searchProductList(keywords);
	}
	
	public List<Product> showProductList(String productId){
		return productDao.showProductList(productId);
	}

}
