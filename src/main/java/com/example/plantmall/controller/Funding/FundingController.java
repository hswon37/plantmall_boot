package com.example.plantmall.controller.Funding;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FundingController {

	@RequestMapping(path="/funding", method=RequestMethod.GET)
	public String funding() {
		return "funding/fundingForm";
	}
	
	@RequestMapping(path="/funding", method=RequestMethod.POST)
	public String funding1() {
		return "funding/funding";
	}
	
	@RequestMapping(path="/communityForm", method=RequestMethod.GET)
	public String communityForm() {
		return "funding/communityForm";
	}
	

	@RequestMapping(path = "/fundingList", method=RequestMethod.GET)
	public String fundingList() {
		return "funding/fundingList";
	}
	
	@RequestMapping(path = "/community", method=RequestMethod.GET)
	public String community() {
		return "funding/community";
	}
	
	
	@RequestMapping(path = "/fundingFuncList", method=RequestMethod.GET)
	public String fundingFuncList() {
		return "funding/fundingFuncList";
	}
	
	@RequestMapping(path = "/orderList", method=RequestMethod.GET)
	public String orderList() {
		return "funding/orderList";
	}
	
}
