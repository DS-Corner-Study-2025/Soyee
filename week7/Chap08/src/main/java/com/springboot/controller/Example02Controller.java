package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Example02Controller {
	@GetMapping("/exam02")	
	public String requestMethod(Model model) {	
	
		return "viewPage02";
	}	
}
