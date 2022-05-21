package com.example.plantmall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.plantmall.domain.Cart;
import com.example.plantmall.domain.CartItem;
import com.example.plantmall.domain.Product;
import com.example.plantmall.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@ModelAttribute("sessionCart")
	public Cart createCart(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("sessionCart");
		if (cart == null) {
			cart = new Cart();
			System.out.println("createCart 카트 널\n\n");
			session.setAttribute("sessionCart", cart);
		}
		return cart;
	}
	
	@RequestMapping("/list")
	public ModelAndView getCartItems(HttpSession session, ModelAndView mav) throws Exception {
		Cart cart = (Cart) session.getAttribute("sessionCart");

		Map<String, CartItem> cartItemMap = new HashMap<String, CartItem>();
		if (cart.getItemMap().isEmpty()) {
			cart.setItemMap(cartItemMap);
		}
		cartItemMap = cart.getItemMap();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		// session에 저장된 userId
//		String userId = (String) session.getAttribute("userId");
		String userId = "te";
//		if (userId == null) {
//			return new ModelAndView("user/login");
//		}

		List<CartItem> cartList = cartService.getCartItemList(userId);
		CartItem cartItem;
		if (cartItemMap.isEmpty()) {

			for (int i = 0; i < cartList.size(); i++) {
				cartItem = cartList.get(i);
//				cartItem.setProduct() product를 productId로 찾아서 넣어야됨
				cartItemMap.put(cartItem.getProductId(), cartItem);	
				System.out.println(cartItem);
			}
		}

		int sumMoney = (cartService.sumMoney(userId) == null) ? 0 : cartService.sumMoney(userId);
		int fee = 3000;
		
		map.put("sumMoney", sumMoney);
		map.put("fee", fee);
		map.put("sum", sumMoney + fee);
		map.put("cartItemList", cartList);
		map.put("numberOfItems", cartList.size());
		map.put("p_name", "제품이름이 지금 없음");
		mav.setViewName("Cart");
		mav.addObject("cart", map);
		return mav;
	}
	
	@RequestMapping("/addItemToCart")
	public ModelAndView addItemToCart(@RequestParam("productId") String produtId,
			@ModelAttribute("sessionCart") Cart cart) throws Exception {
		if (cart.containsProductId(produtId)) {
			cart.incrementQuantityByProductId(produtId);
		}
		else {
			// product 가져오는 메서드
			// Product product = 
			Product product = new Product();
			cart.addProduct(product);
		}
		return new ModelAndView("Cart", "cart", cart);
	}
	
	@RequestMapping("/deleteCartItem")
	public String deleteCartItem(HttpSession session, @RequestParam("productId") String productId, @RequestParam("userId") String userId, 
			@ModelAttribute("sessionCart") Cart cart) throws Exception {
		System.out.println("\n\n deleteCartItem \n\n");

		cartService.deleteCartItem(cart.getItemMap().get(productId));
		return "redirect:/cart/list";
	}
	
	@RequestMapping("/updateCartItem")
	public String updateCartItem(@RequestParam("productId") String productId, @RequestParam("quantity") int quantity,
			@ModelAttribute("sessionCart") Cart cart) throws Exception {
		System.out.println("\n\n updateCartItem- productId: "+ productId + ", quantity: " + quantity + "\n\n");
		cart.setQuantityByProductId(productId, quantity);
		cartService.updateCartItem(cart.getItemMap().get(productId));
		return "redirect:/cart/list";
	}
	
}
