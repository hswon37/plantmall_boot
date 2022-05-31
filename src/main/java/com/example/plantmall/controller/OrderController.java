package com.example.plantmall.controller;

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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.example.plantmall.domain.Cart;
import com.example.plantmall.domain.LineItem;
import com.example.plantmall.domain.Order;
import com.example.plantmall.domain.User;
import com.example.plantmall.service.CartService;
import com.example.plantmall.service.OrderService;
import com.example.plantmall.service.ProductService;

@Controller
@RequestMapping("/order")
@SessionAttributes({"sessionCart", "orderForm"})
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;
	
	@ModelAttribute("orderForm")
	public OrderForm createOrderForm() {
		System.out.println("@ModelAttribute(orderForm) work\n");
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
	public ModelAndView initNewOrder(@RequestParam(value="chkbox") String productIdArray,HttpSession session,
			@ModelAttribute("sessionCart") Cart cart,  @ModelAttribute("orderForm") OrderForm orderForm, ModelAndView mav) throws ModelAndViewDefiningException {
		UserSession userSession = (UserSession)session.getAttribute("userSession");
		User user = userSession.getUser();
//		User user = new User("admin", "admin", "admin", "admin@naver.com", "010-0000-0000", "00000", "경기도");
		String[] productId = productIdArray.split(",");
		
		if (orderForm.getOrder().getLineItems().size() == 0) {
			for (int i = 0; i < productId.length; i++) {
				orderForm.getOrder().addLineItem(cart.getItemMap().get(productId[i].trim()));
			}
			orderForm.getOrder().initOrder(user, orderForm.getOrder().getLineItems());
		}

		mav.addObject("productIdArray", productIdArray);
		mav.setViewName("order/OrderForm");
		return mav;
	}
	
	@RequestMapping("/orderReset")
	public String resetOrder(@ModelAttribute("orderForm") OrderForm orderForm, SessionStatus status) throws ModelAndViewDefiningException {
		status.setComplete();
		return "redirect:/cart/list";
	}
	
	@RequestMapping("/newOrderSubmitted")
	public ModelAndView newOrderSubmitted (@Valid @ModelAttribute("orderForm") OrderForm orderForm, 
			@RequestParam(value="chkbox") String productIdArray, BindingResult result, SessionStatus status) {
		System.out.println("\n /newOrderSubmitted");
		if (result.hasErrors()) {
			System.out.println("hasErrore()\n");
			return new ModelAndView("order/OrderForm");
		}
		
		orderService.insertOrder(orderForm.getOrder());
		ModelAndView mav = new ModelAndView("order/OrderDetail");
		mav.addObject("order", orderForm.getOrder());
		
		String[] productId = productIdArray.split(",");
		for (int i = 0; i < productId.length; i++) {
			cartService.deleteCartItem(orderForm.getOrder().getUserId(), productId[i].trim());
		}
		status.setComplete();
		return mav;
	}
	

	@RequestMapping("/list")
	public ModelAndView orderList(HttpSession session) throws Exception {
		//User user = (User) session.getAttribute("user");
		List<Order> orderList = orderService.getOrdersByUserId("admin");
		for (Order o : orderList) {
			Order o2 = orderService.getOrder(o.getOrderId());
			o.setLineItems(o2.getLineItems());
			for (LineItem item : o.getLineItems()) {
				item.setProduct(productService.getProduct(item.getProductId()));
			}
			o.setTotalPrice(o.setTotalPriceUsingLineItems(o.getLineItems()));
		}

		return new ModelAndView("order/OrderList", "orderList", orderList);
	}
	
	@RequestMapping("/orderDetail")
	public ModelAndView orderDetail(@RequestParam("orderId") int orderId) throws Exception {
		Order order = orderService.getOrder(orderId);
		for (LineItem item : order.getLineItems()) {
			item.setProduct(productService.getProduct(item.getProductId()));
		}
		order.setTotalPrice(order.setTotalPriceUsingLineItems(order.getLineItems()));
		System.out.println(order);
		return new ModelAndView("order/OrderDetail", "order", order);
	}

}
