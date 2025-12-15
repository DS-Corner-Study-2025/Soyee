package com.springboot.controller;


import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.domain.Product;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/exam02")
public class Example02Controller {	
	
	
	
	@GetMapping
	public String showForm(Model model) {
		model.addAttribute("product", new Product()); 
		return "viewPage02";
	}
	
	
	 
	@PostMapping
	public String submit(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model){			
	//	model.addAttribute("product", product); 
		
		if(bindingResult.hasErrors())			
			return "viewPage02";
		    
		return "viewPage02_result";
	}
}
