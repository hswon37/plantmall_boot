package com.example.plantmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class productController {
	//제품 목록
	@RequestMapping("/product/list")
	public String showProductList() {
		return "productList";
	}
	//제품 상세
	@RequestMapping("/product/detail")
	public String showProductDetail() {
		return "productDetail";
	}
	//제품 관리 목록
	@RequestMapping("/product/manage")
	public String showProductManage() {
		return "productManage";
	}
	//제품 등록
	@RequestMapping("/product/registration")
	public String showProductRegistration() {
		return "productRegistration";
	}
	//제품 수정
	@RequestMapping("/product/modify")
	public String showProductModify() {
		return "productModify";
	}
	//제품 삭제
	@RequestMapping("/product/delete")
	public String showProductDelete() {
		return "productDelete";
	}
	//제품 검색
	@RequestMapping("/product/search")
	public String showProductSearch() {
		return "productSearch";
	}
	//제품 검색 결과
	@RequestMapping("/product/searchResult")
	public String showProductSearchResult() {
		return "searchResult";
	}
}
