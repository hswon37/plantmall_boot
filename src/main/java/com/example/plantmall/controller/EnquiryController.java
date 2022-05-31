package com.example.plantmall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.example.plantmall.domain.Enquiry;
import com.example.plantmall.domain.User;
import com.example.plantmall.service.EnquiryService;

@Controller
@RequestMapping("/enquiry")
@SessionAttributes("enqForm")
public class EnquiryController {
	@Autowired
	private EnquiryService enqService;

	@ModelAttribute("enqForm")
	public EnquiryForm createOrderForm() {
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
	
}
