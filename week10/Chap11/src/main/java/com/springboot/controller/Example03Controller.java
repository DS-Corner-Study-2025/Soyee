package com.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Example03Controller {	
	
	@GetMapping("/exam03")
	public void  requestMethod(){
		 throw new UserException("UserException 메시지입니다");
    }
	
	@ExceptionHandler(UserException.class)
	public String handleException(UserException ex, Model model) {
				
		model.addAttribute("data1", ex.getMessage());		
		model.addAttribute("data2", ex);
		
		return "viewPage01";
	}
}
