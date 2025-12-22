package com.springboot.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice(basePackages={"com.springboot"})
public class GlobalException{

	@ExceptionHandler(value={RuntimeException.class})
	private String handleErrorMethod(Exception ex, Model model) {
	  
		model.addAttribute("data1",  "GlobalException 메시지입니다");
		model.addAttribute("data2", ex );

	   return "viewPage01";
	}
	
}
