package com.springboot.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Example02Controller {	
	
	@GetMapping("/exam02")
	public void  requestMethod() throws Exception {
		 throw new Exception(new UserException("UserException 메시지입니다"));
    }
}
