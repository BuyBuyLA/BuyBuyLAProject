package com.web.record_30.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CartController {
	@GetMapping({"/","/test"})
	public String home(Model model) {
		 return "cart_30/TotalHome";
	}
	
	
	
	@GetMapping("/additem")
	public String additem(Model model) {
		 return "cart_30/additem";
	}
	
	
	
	@GetMapping("/cart")
	public String cart(Model model) {
		 return "cart_30/cart";
	}
	
	
	@GetMapping("/deletecart")
	public String deletecart(Model model) {
		 return "cart_30/deletecart";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		 return "cart_30/add";
	}
	
	@GetMapping("/sub")
	public String sub(Model model) {
		 return "cart_30/sub";
	}
	
	@GetMapping("/check")
	public String check(Model model) {
		 return "cart_30/check";
	}
	
	
	@GetMapping("/fin")
	public String fin(Model model) {
		 return "cart_30/fin";
	}
	
	@GetMapping("/removeAllCart")
	public String removeAllCart(Model model) {
		 return "cart_30/removeAllCart";
	}
	
	
	
	
	
	
}
