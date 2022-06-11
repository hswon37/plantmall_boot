package com.example.plantmall.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.plantmall.domain.Funding;
import com.example.plantmall.domain.Product;
import com.example.plantmall.service.FundingService;
import com.example.plantmall.service.ProductService;

@Controller
public class MainController {
	@Autowired
	private ProductService productService;

	@Autowired
	private FundingService fundingService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping("/")
	public String showImages(ModelMap model) throws Exception {
		
		List<Product> bestItemList;
		List<Product> bestItemList5 = new ArrayList<>();
		
		Product plant = this.productService.getAllProduct().get(0);
		Product gardeningSupplies = this.productService.getProductListByCategory("c7").get(0);
		
		Funding funding = this.fundingService.getAllFundingList().get(0);
		Product productHaveFunding = this.productService.getProduct(funding.getProductId());
		
		bestItemList = this.productService.getBestProductList();
		
		for (int i = 0; i < 5; i++)
			bestItemList5.add(bestItemList.get(i));
		
		model.put("bestItemList5", bestItemList5);
		model.put("plant", plant);
		model.put("gardeningSupplies", gardeningSupplies);
		model.put("productHaveFunding", productHaveFunding);
		
		return "main";
	}
}
