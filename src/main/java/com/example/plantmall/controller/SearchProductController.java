package com.example.plantmall.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.plantmall.service.ProductService;
import com.example.plantmall.domain.Category;

@Controller
public class SearchProductController {
	private ProductService productService;
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//제품 검색
	@RequestMapping("/product/search")
	public String showProductSearch(ModelMap model) {
		List<Category> categoryList = this.productService.getCategoryList();
		List<String> categoryNameList =  new ArrayList<String>();
		
		for (Category c : categoryList)
			categoryNameList.add(c.getC_name());
		
		model.put("categoryNameList", categoryNameList);
		
		System.out.println("제품 검색 카테고리명 model -> view 전달");
		
		return "product/productSearch";
	}
	//제품 검색 결과
	@RequestMapping("/product/searchResult")
	public String showProductSearchResult() {
		return "product/searchResult";
	}
}
