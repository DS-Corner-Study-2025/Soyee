package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Example03Controller {
	
	
	@GetMapping("/exam03")	
	public String requestMethod(Model model) {			
	
	return "viewPage03";
	}	
}
