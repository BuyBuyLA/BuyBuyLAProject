package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


	@GetMapping("/")
	public String home0(Model model) {
		 return "cart_30/TotalHome";
	}
	
	
}

