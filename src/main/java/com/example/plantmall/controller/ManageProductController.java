package com.example.plantmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManageProductController {
	
		//제품 관리 목록
		@RequestMapping("/product/manage")
		public String showProductManage() {
			return "product/productManage";
		}
		//제품 등록
		@RequestMapping("/product/registration")
		public String showProductRegistration() {
			return "product/productRegistration";
		}
		//제품 수정
		@RequestMapping("/product/modify")
		public String showProductModify() {
			return "product/productModify";
		}
		//제품 삭제
		@RequestMapping("/product/delete")
		public String showProductDelete() {
			return "product/productDelete";
		}
}
