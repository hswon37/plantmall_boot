package com.example.plantmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchProductController {

	//제품 검색
	@RequestMapping("/product/search")
	public String showProductSearch() {
		return "product/productSearch";
	}
	//제품 검색 결과
	@RequestMapping("/product/searchResult")
	public String showProductSearchResult() {
		return "product/searchResult";
	}
}
