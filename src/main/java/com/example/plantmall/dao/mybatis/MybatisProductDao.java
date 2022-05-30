package com.example.plantmall.dao.mybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.plantmall.dao.ProductDao;
import com.example.plantmall.dao.mybatis.mapper.ProductMapper;
import com.example.plantmall.dao.mybatis.mapper.ReviewMapper;
import com.example.plantmall.domain.Product;
import com.example.plantmall.domain.Review;

@Repository
public class MybatisProductDao implements ProductDao {
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private ReviewMapper reviewMapper;
	
	public List<Product> getProductListByCategory(String categoryId) 
			throws DataAccessException {
	    return productMapper.getProductListByCategory(categoryId);
	}

	public Product getProduct(String productId) throws DataAccessException {
	    return productMapper.getProduct(productId);
	}

	public List<Product> searchProductList(String keywords) 
			throws DataAccessException {
	    return productMapper.searchProductList(
	    	"%" + keywords.toLowerCase() + "%");
	}

	/* Inner Classes */
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
	public List<Review> getReviewsByProductId(String productId) throws DataAccessException {
		// TODO Auto-generated method stub
		return reviewMapper.getReviewsByProductId(productId);
	}

	@Override
	public Product getProductAndReviewList(String productId) throws DataAccessException {
		// TODO Auto-generated method stub
		return productMapper.getProductAndReviews(productId);
	}	
}