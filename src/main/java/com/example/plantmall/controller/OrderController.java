package com.example.plantmall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.example.plantmall.domain.Cart;
import com.example.plantmall.domain.Order;
import com.example.plantmall.domain.User;
import com.example.plantmall.service.OrderService;

@Controller
@RequestMapping("/order")
@SessionAttributes({"sessionCart", "orderForm"})
public class OrderController {

	@Autowired
	private OrderService orderService;
	
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
	
	@RequestMapping("/newOrder")
	public String initNewOrder(HttpServletRequest request, @RequestParam(value="chkbox[]") List<String> productId,
			@ModelAttribute("sessionCart") Cart cart,  @ModelAttribute("orderForm") OrderForm orderForm) throws ModelAndViewDefiningException {
		User user = (User) request.getSession().getAttribute("user");
		
		for (String p : productId) {
			orderForm.getOrder().addLineItem(cart.getItemMap().get(p));
		}
		orderForm.getOrder().initOrder(user, orderForm.getOrder().getLineItems());
		return "OrderForm";
	}
	
	@RequestMapping("/newOrderSubmitted")
	public ModelAndView newOrderSubmitted (@Valid @ModelAttribute("orderForm") OrderForm orderForm, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("OrderForm");
		}
		orderService.insertOrder(orderForm.getOrder());
		ModelAndView mav = new ModelAndView("OrderDetail");
		mav.addObject("order", orderForm.getOrder());
		return mav;
	}
	

	@RequestMapping("/list")
	public ModelAndView orderList(HttpSession session) throws Exception {
		User user = (User) session.getAttribute("user");
		return new ModelAndView("OrderList", "orderList", orderService.getOrdersByUserId(user.getUserId()));
	}
	
	@RequestMapping("/orderDetail")
	public ModelAndView orderDetail(@RequestParam("orderId") int orderId) throws Exception {
		Order order = orderService.getOrder(orderId);
		return new ModelAndView("OrderDetail", "order", order);
	}
	
}
