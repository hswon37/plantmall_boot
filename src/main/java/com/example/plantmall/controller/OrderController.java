package com.example.plantmall.controller;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.plantmall.domain.User;

@Controller
@RequestMapping("/order")
public class OrderController {

	@ModelAttribute("orderForm")
	public OrderForm createOrderForm() {
		return new OrderForm();
	}
	
	@ModelAttribute("creditCardTypes")
	public List<String> referenceData() {
		ArrayList<String> creditCardTypes = new ArrayList<String>();
		creditCardTypes.add("Visa");
		creditCardTypes.add("MasterCard");
		return creditCardTypes;			
	}
	
	@GetMapping()
	public String form() {
		return "/orderForm";
	}
	
	@PostMapping()
	public String submit(HttpServletRequest request, @ModelAttribute("orderForm") OrderForm orderForm) {
		User user = (User) request.getSession().getAttribute("user");
		
	}
}
