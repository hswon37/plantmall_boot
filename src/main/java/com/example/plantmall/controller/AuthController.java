package com.example.plantmall.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.util.WebUtils;

import com.example.plantmall.dao.UserDao;
import com.example.plantmall.dao.mybatis.MybatisUserDao;
import com.example.plantmall.dao.mybatis.mapper.UserMapper;
import com.example.plantmall.domain.User;
import com.example.plantmall.service.AuthService;

@Controller
public class AuthController{
	
	@Value("/auth/signupForm")
	private String formViewName;
	
	@Autowired
	private AuthService authService;
	
	@ModelAttribute("userForm")
	public UserForm formBackingObject(HttpServletRequest request) throws Exception{
		UserSession userSession=
				(UserSession)WebUtils.getSessionAttribute(request, "userSession");
		if(userSession!=null) {
			return new UserForm(authService.getUser(userSession.getUser().getEmail()));
		}else {
			return new UserForm();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	@RequestMapping(path = "/authFuncList", method=RequestMethod.GET)
	public String authFuncList(Model model) {
		return "/auth/authFuncList";
	}
	
	
	
}
