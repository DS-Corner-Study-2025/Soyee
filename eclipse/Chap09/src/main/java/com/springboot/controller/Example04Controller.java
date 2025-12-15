package com.springboot.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.domain.Person;
import com.springboot.domain.PersonValidator;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/exam04")
public class Example04Controller {	

	 @Autowired
	private PersonValidator personValidator;
		 
	@GetMapping
	public String showForm(Model model) {
		model.addAttribute("person", new Person());
		return "viewPage04";
	}

	@PostMapping
	public String submit(@Valid @ModelAttribute Person person,BindingResult bindingResult)		{
		
		//personValidator.validate(person, bindingResult);
		
		if (bindingResult.hasErrors()) 
			return "viewPage04";
	
		 
		return "viewPage04_result";
	}

	 @InitBinder
	    protected void initBinder(WebDataBinder binder) {
	        binder.setValidator(personValidator);
	    }

}
