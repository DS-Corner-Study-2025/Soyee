package com.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class Example01Controller {	
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="요청 실패했습니다.")
	@GetMapping("/exam01")
	public void  requestMethod() {
		System.out.print(new IllegalArgumentException("요청 실패했습니다.").getMessage());	
    }
    
	
	
	
}
