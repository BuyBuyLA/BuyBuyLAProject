package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")//改
	public String home0(Model model) {
		System.out.println("ㄎㄎc");
		 return "cart_30/TotalHome";
	}

}
