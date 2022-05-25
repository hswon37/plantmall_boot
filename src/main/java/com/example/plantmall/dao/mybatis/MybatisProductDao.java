package com.example.plantmall.dao.mybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.plantmall.dao.ProductDao;
import com.example.plantmall.dao.mybatis.mapper.ProductMapper;
import com.example.plantmall.domain.Product;

@Repository
public class MybatisProductDao implements ProductDao {
	@Autowired
	private ProductMapper productMapper;

	@Override
	public Product getProduct(String productId) throws DataAccessException {
	    return productMapper.getProduct(productId);
	}
	
	@Override
	public List<Product> getProductListByCategory(String categoryId) 
			throws DataAccessException {
	    return productMapper.getProductListByCategory(categoryId);
	}

	@Override
	public List<Product> searchProductList(String keywords) 
			throws DataAccessException {
	    return productMapper.searchProductList(
	    	"%" + keywords.toLowerCase() + "%");
	}

	/* Inner Classes: 이게 뭐지? jpetstore꺼 긁어온거긴함*/
	public static class ProductSearch {

		private List<String> keywordList = new ArrayList<String>();

		public ProductSearch(String keywords) {
			StringTokenizer splitter = new StringTokenizer(keywords," ",false);
			while (splitter.hasMoreTokens()) {
				this.keywordList.add("%" + splitter.nextToken() + "%");
			}
		}
		public List<String> getKeywordList() {
			return keywordList;
		}
	}
	
	@Override
	public List<Product> showProductList(String productId) throws DataAccessException{
		return productMapper.showProductList(productId);
	}
	
	@Override
	public List<Product> getAllProduct(){
		return productMapper.getAllProduct();
	}

	@Override
	public void insertProduct(Product product) throws DataAccessException{
		productMapper.insertProduct(product);
	}

	@Override
	public void updateProduct(Product product) throws DataAccessException{
		productMapper.updateProduct(product);
	}

	@Override
	public void deleteProduct(Product product) throws DataAccessException{
		productMapper.deleteProduct(product);
	}

}