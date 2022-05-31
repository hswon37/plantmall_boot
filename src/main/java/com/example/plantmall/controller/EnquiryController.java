package com.example.plantmall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import com.example.plantmall.domain.Enquiry;
import com.example.plantmall.domain.LineItem;
import com.example.plantmall.domain.Product;
import com.example.plantmall.domain.Review;
import com.example.plantmall.domain.User;
import com.example.plantmall.service.EnquiryService;
import com.example.plantmall.service.ProductService;

@Controller
@RequestMapping("/enquiry")
@SessionAttributes("enqForm")
public class EnquiryController {
	@Autowired
	private EnquiryService enqService;
	@Autowired
	private ProductService productService;
	
	@ModelAttribute("enqForm")
	public EnquiryForm createEnquiryForm() {
		System.out.println("@ModelAttribute(enqForm) work\n");
		return new EnquiryForm();
	}
	
	@RequestMapping("/newEnquiry")
	public ModelAndView preNewEnquiry(@RequestParam("productId") String productId, 
			@ModelAttribute("enqForm") EnquiryForm enqForm, ModelAndView mav, HttpSession session) throws ModelAndViewDefiningException
	{
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		if (userSession == null) {
			return new ModelAndView("auth/loginForm");
		}
		User user = userSession.getUser();

		enqForm.getEnquiry().initEnq(productId, user.getUserId());

		return new ModelAndView("enqury/EnquiryForm");
	}
	
	@RequestMapping("newEnquirySubmitted")
	public String newReviewSubmitted(@Valid @ModelAttribute("enquiryForm") EnquiryForm enqForm, BindingResult result, SessionStatus status,
			ModelAndView mav) {
		System.out.println("\n /newEnquirySubmitted");
		if (result.hasErrors()) {
			System.out.println("hasErrore()\n");
			return "enquiry/EnquiryForm";
		}
		enqService.insertEnquiry(enqForm.getEnquiry());
		List<Enquiry> list = enqService.getEnquiryListByProductId(enqForm.getEnquiry().getProductId());
		Product product = productService.getProduct(enqForm.getEnquiry().getProductId());
		product.setEnquiryList(list);
		
		mav.setViewName("product/productDetail");
		status.setComplete();

		return "product/productDetail?productId="+product.getProductId();
	}
	
}
