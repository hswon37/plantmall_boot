package com.example.plantmall.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.plantmall.dao.CategoryDao;
import com.example.plantmall.dao.ProductDao;
import com.example.plantmall.domain.Category;
import com.example.plantmall.domain.Product;
import com.example.plantmall.controller.SearchValueCommand;
//import com.example.plantmall.domain.User;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired   
	private CategoryDao categoryDao;	

	@Autowired  
	private ProductDao productDao;
	
	public Product getProduct(String productId) {
		return productDao.getProduct(productId);
	}

	public List<Product> getProductHaveLineItem(String productId) {
		return productDao.getProductHaveLineItem(productId);
	}
	
	public Category getCategory(String categoryId) {
		return categoryDao.getCategory(categoryId);
	}
	
	public List<Category> getCategoryList() {
		return categoryDao.getCategoryList();
	}

	public List<Product> getProductListByCategory(String categoryId) {
		return productDao.getProductListByCategory(categoryId);
	}

	public List<Product> getAllProduct() {
		return productDao.getAllProduct();
	}
	
	public List<Product> searchProductList(SearchValueCommand svc) {
		return productDao.searchProductList(svc);
	}
	
	public List<Product> showProductList(String productId){
		return productDao.showProductList(productId);
	}
	
	public List<Product> getProductListforUser(String userId){
		return productDao.getProductListforUser(userId);
	}

	public void insertProduct(Product product){
		productDao.insertProduct(product);
	}
	
	public void updateProduct(Product product){
		productDao.updateProduct(product);
	}

	public void deleteProduct(Product product){
		productDao.deleteProduct(product);
	}
	
	public void deleteContentHaveProduct(Product product){
		productDao.deleteContentHaveProduct(product);
	}
}
