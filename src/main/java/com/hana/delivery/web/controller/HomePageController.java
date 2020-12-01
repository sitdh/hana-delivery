package com.hana.delivery.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
	
	@GetMapping("/")
	public String index(ModelMap model) {
		String hello = "Hello from model";
		model.addAttribute("test", hello);
		
		return "index";
	}

}
