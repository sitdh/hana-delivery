package com.hana.delivery.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomePageController {
	
	@GetMapping("/")
	public String index(ModelMap model) {
		String hello = "Hello from model";
		model.addAttribute("test", hello);
		model.addAtribute('name', 'Champ')
		
		return "index";
	}

}
