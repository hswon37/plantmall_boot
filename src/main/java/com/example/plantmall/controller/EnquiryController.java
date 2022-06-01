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
import com.example.plantmall.domain.Product;
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
			@ModelAttribute("enqForm") EnquiryForm enqForm, ModelAndView mav, HttpSession session)
			throws ModelAndViewDefiningException {
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		if (userSession == null) {
			return new ModelAndView("auth/loginForm");
		}
		User user = userSession.getUser();
		enqForm.getEnquiry().initEnq(productId, user.getUserId());
//		enqForm.getEnquiry().initEnq(productId, "test");
		System.out.println(enqForm.getEnquiry());
		return new ModelAndView("enquiry/EnquiryForm");
	}
	
	@RequestMapping("newEnquirySubmitted")
	public String newEnquirySubmitted(@Valid @ModelAttribute("enqForm") EnquiryForm enqForm, BindingResult result, SessionStatus status) {
		System.out.println("\n /newEnquirySubmitted");
		if (result.hasErrors()) {
			System.out.println("hasErrore()\n");
			return "enquiry/EnquiryForm";
		}
		System.out.println(enqForm.getEnquiry());
		enqService.insertEnquiry(enqForm.getEnquiry());
		List<Enquiry> list = enqService.getEnquiryListByProductId(enqForm.getEnquiry().getProductId());
		Product product = productService.getProduct(enqForm.getEnquiry().getProductId());
		product.setEnquiryList(list);
		
		status.setComplete();

		return "redirect:/product/detail?productId="+product.getProductId();
	}
	
	@RequestMapping("/updateEnquiryForm")
	public String updateEnquiry(@ModelAttribute("enqForm") EnquiryForm enqForm, @RequestParam("enquiryId") int enquiryId) {
		enqForm.getEnquiry().initEnq(enqService.getEnquiryByEnquiryId(enquiryId));
		return "Enquiry/UpdateEnquiry";
	}
	
	@RequestMapping("/updateEnquirySubmitted")
	public String updateEnquirySubmitted(@ModelAttribute("enqForm") EnquiryForm enqForm, SessionStatus status) {
		enqService.updateEnquiry(enqForm.getEnquiry());
		status.setComplete();
		return "redirect:/product/detail?productId="+enqForm.getEnquiry().getProductId();
	}
	
	@RequestMapping("/deleteEnquiry")
	public String deleteEnquiry(@RequestParam("enquiryId") int enqId, @RequestParam("productId") String productId) {
		enqService.deleteEnquiry(enqId);
		return "redirect:/product/detail?productId="+productId;
	}
	
//	@RequestMapping("/insertComment")
//	public String insertComment(@RequestParam("enquiryId") int enqId, @RequestParam("seller") String userId) {
//		
//	}
}