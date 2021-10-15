package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
	public HomeController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/")   //改
	public String indexDefault() {
		System.out.println("回首頁");
		return "member_25/tryIndex";
}
}

