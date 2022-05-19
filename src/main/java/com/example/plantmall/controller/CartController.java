package com.example.plantmall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

	@GetMapping()
	public String getCartItems(HttpSession session, Model model) throws Exception {
		// session에 저장된 userId
		String userId = (String) session.getAttribute("userId");
		List<CartItem> cartItem = 
	}
}
