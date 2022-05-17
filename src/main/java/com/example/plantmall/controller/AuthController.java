package com.example.plantmall.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.plantmall.dao.UserDao;
import com.example.plantmall.dao.mybatis.MybatisUserDao;
import com.example.plantmall.dao.mybatis.mapper.UserMapper;
import com.example.plantmall.domain.User;

@Controller
public class AuthController{
	
	@Autowired
	private UserDao userDao;

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
	public ModelAndView submit(@ModelAttribute("UserInfo") User userInfo) {
		ModelAndView mav = new ModelAndView();
	
		User reg = userDao.getUser(userInfo.getEmail(), userInfo.getPassword());
		if(reg==null) {
			mav.setViewName("/auth/error");
			mav.addObject("errorMessage", "아이디, 비밀번호를 확인해주세요");
		}else {
			mav.setViewName("/auth/created");
			mav.addObject("completedUser", reg);
		}	
		return mav;
	}
	
	@RequestMapping(path = "/settings", method=RequestMethod.GET)
	public String settings() {
		return "auth/settings";
	}
	
	@RequestMapping(path = "/signupForm", method=RequestMethod.GET)
	public String singupForm() {
		return "auth/signupForm";
	}
	
	@RequestMapping(path = "/signupForm", method=RequestMethod.POST)
	public ModelAndView submitSign(@Validated @ModelAttribute("UserInfo") User userInfo, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.addObject("errorMessage", "회원가입 실패");
			mav.setViewName("/auth/error");
		}

		mav.setViewName("/auth/created");
		userDao.insertUser(userInfo);
		mav.addObject("completedUser", userInfo);
		return mav; 
	}
	

	
	@RequestMapping(path = "/created", method=RequestMethod.GET)
	public String created() {
		return "auth/created";
	}
	
	
	@RequestMapping(path = "/authFuncList", method=RequestMethod.GET)
	public String authFuncList(Model model) {
		return "/auth/authFuncList";
	}
	
	
	
}
