package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.springboot.repository.MemberRepository04;
import com.springboot.domain.Member;

@Controller
@RequestMapping("/exam04")
public class Example04Controller {
	
	@Autowired
	MemberRepository04 repository;
	
	@GetMapping
	public String viewHomePage(Model model) {
	
				 
		List<Member> memberList = repository.selectMethod();
		System.out.println(memberList);
		model.addAttribute("memberList", memberList);
		return "viewPage04";
	}
	
	@GetMapping("/new")
	public String newMethod(Model model) {
		Member member = new Member();
		model.addAttribute("member", member);
		
		return "viewPage04_new";
	}
	
	@PostMapping("/insert")
	public String insertMethod(@ModelAttribute("member") Member member) {
		
		//repository.save(member);	
		repository.insertMethod(member);
		System.out.println("member                " + member);
		return "redirect:/exam04";
	}

	@GetMapping("/edit/{id}")
	public String editMethod(@PathVariable(name = "id") int id, Model model) {				
		
		Member member = repository.selectMethodById(id);
		
		 model.addAttribute("member", member);
		
		return "viewPage04_edit";
	}	

	@PostMapping("/update")
	public String updateMethod(@ModelAttribute("member") Member member) {
		
		repository.updateMethod(member);
		//repository.updateMethod2(member.getId(), member.getName(), member.getPrice() );
		//repository.save(member);					
		return "redirect:/exam04";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteMethod(@PathVariable(name = "id") int id) {
			
		//repository.deleteById(id);
		repository.deleteMethod(id);
		return "redirect:/exam04";
	}

}
