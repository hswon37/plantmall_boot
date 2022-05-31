package com.example.plantmall.controller.Funding;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping(path={"/create","/update"},method=RequestMethod.GET)
	public ModelAndView showForm(@RequestParam(value="fundingId", required=false)String fundingId,HttpServletRequest request) {
		UserSession userSession=
				(UserSession)WebUtils.getSessionAttribute(request, "userSession");
		
		ModelAndView mav = new ModelAndView();
		
		if(userSession!=null) {
			List<Product> list = productService.getProductListforUser(userSession.getUser().getUserId());
			mav.addObject("productList",list);
			mav.setViewName(formViewName);

			if(fundingId==null) {
			mav.addObject("fundingForm",new FundingForm());				
			}else {
				mav.addObject("fundingForm",new FundingForm(fundingService.getFunding(fundingId)));				
			}
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
			if(fundingForm.getFunding().getFundingId() !=null) {
				fundingService.updateFunding(fundingForm.getFunding());
				System.out.println("funding 수정");
				
			}else {
				fundingService.insertFunding(fundingForm.getFunding());
				System.out.println("funding 생성");
			}
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
	
	@RequestMapping("/{fundingId}")
	public ModelAndView viewFundingDetail(@PathVariable String fundingId, HttpServletRequest request) {
		UserSession userSession=
				(UserSession)WebUtils.getSessionAttribute(request, "userSession");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("funding/funding");
		
		Funding funding = fundingService.getFunding(fundingId);
		Product product = productService.getProduct(funding.getProductId());
		
		mav.addObject("funding",funding);
		mav.addObject("product", product);
		
		if(userSession!=null) {
			if(product.getUserId().equals(userSession.getUser().getUserId())) {
				mav.addObject("isSeller", true);
				return mav;
			}
		}
		mav.addObject("isSeller", false);
		return mav;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteFunding(@RequestParam(value="fundingId", required=false) String fundingId, HttpSession session) {
		UserSession userSession=
				(UserSession)session.getAttribute("userSession");
		
		
		if(fundingId !=null) {
			fundingService.deleteFunding(fundingId);
		}
		
		return fundingMain();
	}
	
	
}
