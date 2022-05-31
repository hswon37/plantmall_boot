package com.example.plantmall.controller.Funding;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.example.plantmall.controller.UserForm;
import com.example.plantmall.controller.UserSession;
import com.example.plantmall.domain.Funding;
import com.example.plantmall.domain.Product;
import com.example.plantmall.service.FundingService;
import com.example.plantmall.service.ProductService;

@Controller
@RequestMapping("/funding")
public class FundingController {

	@Value("funding/fundingForm")
	private String formViewName;
	
	@Autowired
	private FundingService fundingService;
	
	@Autowired
	private ProductService productService;
	
	@ModelAttribute("fundingForm")
	public FundingForm formBackingObject() throws Exception{
		return new FundingForm();
	}
	
	@RequestMapping(path="/create",method=RequestMethod.GET)
	public ModelAndView showForm(HttpServletRequest request) {
		UserSession userSession=
				(UserSession)WebUtils.getSessionAttribute(request, "userSession");
		
		ModelAndView mav = new ModelAndView();
		
		if(userSession!=null) {
			List<Product> list = productService.getProductListforUser(userSession.getUser().getUserId());
			mav.setViewName(formViewName);
			mav.addObject("fundingForm",new FundingForm());
			mav.addObject("productList",list);
		}else {
			mav.setViewName("/auth/error");
			mav.addObject("errorMessage", "로그인을 해주세요.");
		}
		return mav;
	}
	
	@RequestMapping(path="/create",method=RequestMethod.POST)
	public ModelAndView submitted(HttpServletRequest request, @ModelAttribute("fundingForm") FundingForm fundingForm) {
		UserSession userSession=
				(UserSession)WebUtils.getSessionAttribute(request, "userSession");
		
		ModelAndView mav = new ModelAndView();
		
		if(userSession!=null) {
			fundingService.insertFunding(fundingForm.getFunding());
			mav.setViewName("funding/fundingList");
		}else {
			mav.setViewName("/auth/error");
			mav.addObject("errorMessage", "로그인을 해주세요.");
		}
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView fundingMain()
	{
		ModelAndView mav = new ModelAndView();
		
		List<Funding> list = fundingService.getAllFundingList();
		
		mav.setViewName("funding/fundingList");
		mav.addObject("fundingList",list);
		return mav;
		
	}
	
	

	
	
}
