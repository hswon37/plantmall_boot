package com.example.plantmall.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
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
@RequestMapping({"/signup","/auth/edit"})
public class AuthController{
	
	@Value("auth/signupForm")
	private String formViewName;
	
	@Value("auth/created")
	private String successViewName;
	
	@Autowired
	private AuthService authService;
	
	@ModelAttribute("userForm")
	public UserForm formBackingObject(HttpServletRequest request) throws Exception{
		UserSession userSession=
				(UserSession)WebUtils.getSessionAttribute(request, "userSession");
		
		if(userSession!=null) {
			System.out.println("userSession!"+userSession.getUser());
			return new UserForm(
					authService.getUser(userSession.getUser().getEmail()));
		}else {
			return new UserForm();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpSession session, @ModelAttribute("userForm") UserForm userForm) throws Exception{
		
			if(userForm.isNewUser()) {
				//회원가입 진행
				authService.insertUser(userForm.getUser());
			}else {
				//회원수정 진행
				authService.updateUser(userForm.getUser());
			}
			
			UserSession userSession = new UserSession(
					authService.getUser(userForm.getUser().getEmail()));
			
			System.out.println("!!!"+userSession.getUser());
			session.setAttribute("userSession", userSession);
			return successViewName;
	}

	

	@RequestMapping(path = "/authFuncList", method=RequestMethod.GET)
	public String authFuncList(Model model, HttpServletRequest request, HttpSession session) {
		session.invalidate();
		return "auth/authFuncList";
	}
	
	@RequestMapping(path = "/auth/created", method=RequestMethod.GET)
	public String created(Model model, HttpServletRequest request, HttpSession session) {
		return "auth/created";
	}	
	
	
}
