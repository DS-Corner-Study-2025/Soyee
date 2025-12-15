package com.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.springboot.domain.Product;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/exam01")
public class Example01Controller {	
	
	
	@Autowired
	MessageSource messageSource;
	@GetMapping
	public String showForm(Model model) {
		model.addAttribute("product", new Product()); 
		return "viewPage01";
	}
	
	
	 /*
	@PostMapping
	public String submit(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model){			
		model.addAttribute("product", product);
		
		if(bindingResult.hasErrors()) { 		
			Map<String, String> validatorResult = new HashMap<>();
			for (FieldError error : bindingResult.getFieldErrors()) {	                 
				String validKeyName = String.format("valid_%s", error.getField());        
				validatorResult.put(validKeyName, error.getDefaultMessage());						        		
        		

			}
			for (String key : validatorResult.keySet()) {
		        model.addAttribute(key, validatorResult.get(key));
		    }
			
			// (FieldError error : bindingResult.getFieldErrors()) { 	                
			//	 model.addAttribute(error.getField(), error.getDefaultMessage());
			//}
				 		    
		
			return "viewPage01";
		}		    
		return "viewPage01_result";
	}
	*/
	@PostMapping
	public String submit(@Valid @ModelAttribute Product product, BindingResult bindingResult){			
		
		
		if(bindingResult.hasErrors()) 	
			return "viewPage01";
				    
		return "viewPage01_result";
	}
}

