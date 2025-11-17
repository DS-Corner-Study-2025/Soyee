package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Example04Controller {
	
	
	@GetMapping("/exam04")	
	public String requestMethod(Model model) {	
		
	
	return "viewPage04";
	}	
}
