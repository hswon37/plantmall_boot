package com.example.plantmall.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.plantmall.dao.mybatis.mapper.UserMapper;
import com.example.plantmall.domain.User;

@Controller
public class AuthController{
	
	@Autowired
	private UserMapper userMapper;

	@ModelAttribute("UserInfo")
	public User UserInfo(HttpServletRequest request) {
		if(request.getMethod().equalsIgnoreCase("GET")) {
			User userInfo = new User();
			return userInfo;
		}else {
			return new User();
		}
	}
	@RequestMapping(path = "/login", method=RequestMethod.GET)
	public String loginForm() {
		return "auth/loginForm";
	}
	
	@RequestMapping(path = "/login", method=RequestMethod.POST)
	public String submit(@ModelAttribute("UserInfo") User userInfo) {
			
		return "auth/created";
	}
	
	@RequestMapping(path = "/settings", method=RequestMethod.GET)
	public String settings() {
		return "auth/settings";
	}
	@RequestMapping(path = "/signupForm", method=RequestMethod.GET)
	public String singupForm() {
		return "auth/signupForm";
	}
	
	@RequestMapping(path = "/created", method=RequestMethod.GET)
	public String created() {
		return "auth/created";
	}
	
	
	@RequestMapping(path = "/authFuncList", method=RequestMethod.GET)
	public String authFuncList(Model model) {
		model.addAttribute("list",userMapper.selectList());
		return "/auth/authFuncList";
	}
	
	
	
}
