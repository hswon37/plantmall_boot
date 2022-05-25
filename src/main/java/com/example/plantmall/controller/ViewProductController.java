package com.example.plantmall.controller;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.plantmall.service.ProductService;
import com.example.plantmall.domain.Product;
//import com.example.plantmall.domain.User;

@Controller
public class ViewProductController {
	
	private ProductService productService;
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	//모든 제품 목록 보기
	@RequestMapping("/product/list")
	public String handleRequest(ModelMap model) throws Exception {
		List<Product> itemList = this.productService.getAllProduct();
		List<Product> productList = new ArrayList<>();
		List<String> userNameList = new ArrayList<>();;
		
		for (Product p : itemList) {
	//		String userName = this.~.getUserName(p.userId); //현재 user명 가져오는 방법 없음..
			String userName = "admin";	//임시 userName
			productList.add(p);
			userNameList.add(userName);
		}
		
		model.put("productList", productList);
		model.put("userNameList", userNameList);
		return "product/productList";
	}
}
