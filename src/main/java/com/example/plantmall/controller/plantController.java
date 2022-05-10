package com.example.plantmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class plantController {
	@RequestMapping("/")	// http://localhost:8080/으로 접속 시
	public String plantmall() {
		System.out.println("plantmall()");
		return "index";
	}
}
