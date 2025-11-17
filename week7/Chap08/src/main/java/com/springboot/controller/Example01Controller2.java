package com.springboot.controller;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Example01Controller2 {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/exam01_2")	
	public String requestMethod(Model model) {	
		
		
	
		model.addAttribute("data", messageSource.getMessage("Person.form.Enter.message", null, Locale.getDefault() )); 	
		return "viewPage01_2";
	}	

}
