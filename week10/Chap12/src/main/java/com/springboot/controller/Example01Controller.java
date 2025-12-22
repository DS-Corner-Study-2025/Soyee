package com.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Example01Controller {	

	@GetMapping("/exam01")
	public String  requestMethod2(Model model) {
		Logger logger = LoggerFactory.getLogger(Example01Controller.class);	
		logger.trace("Trace 메시지!");
		logger.debug("Debug 메시지!");
		logger.info("Info 메시지!");
		logger.warn("Warn 메시지!");
		logger.error("Error 메시지!"); 
		
		  model.addAttribute("data","Slf4j로 로그 출력하기" );
        
        return "viewPage";
	
	}
	
}
