package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class Example04Controller  {
	@GetMapping("/exam04")	
	public String requestMethod(Model model) {
		
		 
		 log.info("Info 메시지!");		 
		  model.addAttribute("data","인터셉터로 로그 출력하기" ); 	
	   	  
		  return "viewPage";
	   }
}
