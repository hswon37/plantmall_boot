package com.example.plantmall.controller;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping("/product/list")
	public String handleRequest(@RequestParam(value="categoryId", required=false) String categoryId, 
								ModelMap model) throws Exception {
		List<Product> itemList;
		String categoryName;
		
		//모든 제품 목록 보기
		if (categoryId == null) {
			itemList = this.productService.getAllProduct();
			categoryName = "전체"; 
		}
		//카테고리별 제품 목록 보기
		else {
			itemList = this.productService.getProductListByCategory(categoryId);
			categoryName = this.productService.getCategory(categoryId).getC_name();
			if (categoryName.equals("flower"))
				categoryName = "꽃";
			else if (categoryName.equals("wildflower"))
				categoryName = "야생화";
			else if (categoryName.equals("herb"))
				categoryName = "허브";
			else if (categoryName.equals("tree"))
				categoryName = "나무";
			else if (categoryName.equals("succulentPlant"))
				categoryName = "다육";
			else if (categoryName.equals("marineAlgae"))
				categoryName = "해조";
			else if (categoryName.equals("gardeningSupplies"))
				categoryName = "원예용품";
		}
		List<List<Product>> productList = new ArrayList<>();
		List<List<String>> userNameList = new ArrayList<>();

		try {
			for (int i = 0; i < itemList.size(); i += 4) {
				List<Product> miniProductList = new ArrayList<>();
				List<String> miniUserNameList = new ArrayList<>();
				 
				productList.add(miniProductList);
				userNameList.add(miniUserNameList);
				for (int j = 0; j < 4; j++) {
			//		String userName = this.~.getUserName(p.userId); //현재 user명 가져오는 방법 없음..
					String userName = "admin";	//임시 userName
					miniProductList.add(itemList.get(i+j));
					miniUserNameList.add(userName);
				} 
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("더 이상 제품을 찾을 수 없음");
		}
		System.out.println(categoryName+" 카테고리 제품 model -> view 전달");

		model.put("categoryName", categoryName);
		model.put("productList", productList);
		model.put("userNameList", userNameList);
		return "product/productList";		
	}	
	
}
