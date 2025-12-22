package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class Example02Controller {	

	
	@GetMapping("/exam02")
	public String  requestMethod2(Model model) {
		
		 log.trace("Trace 메시지!");
		 log.debug("Debug 메시지!");
		 log.info("Info 메시지!");
		 log.warn("Warn 메시지!");
		 log.error("Error 메시지!"); 
		
		 
		  model.addAttribute("data","@Slf4j로 로그 출력하기" );
        
        return "viewPage";
	
	}
}
