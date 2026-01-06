package com.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.springboot.domain.Member;
import com.springboot.repository.MemberRepository03;

@Controller
@RequestMapping("/exam03")
public class Example03Controller {
	
	@Autowired
	MemberRepository03 repository;
	
	@GetMapping
	public String viewHomePage(Model model) {		
				 
		Iterable<Member> memberList = repository.selectMethod();
		System.out.println(memberList);
		model.addAttribute("memberList", memberList);
		return "viewPage03";
	}
	
	@GetMapping("/new")
	public String newMethod(Model model) {
		Member member = new Member();
		model.addAttribute("member", member);
		
		return "viewPage03_new";
	}
	
	@PostMapping("/insert")
	public String insertMethod(@ModelAttribute("member") Member member) {		
		repository.insertMethod(member.getName(), member.getAge(), member.getEmail());
		//repository.insertMethod2(member);
		return "redirect:/exam03";
	}
	
	@GetMapping("/edit/{id}")
	public String editMethod(@PathVariable(name = "id") int id, Model model) {				
		
		Member  member = repository.selectMethodById(id);
		
		 model.addAttribute("member", member);
		
		return "viewPage03_edit";
	}	
	
	@PostMapping("/update")
	public String updateMethod(@ModelAttribute("member") Member member) {
		
		repository.updateMethod( member.getName(), member.getAge(), member.getEmail(), member.getId());	
		//repository.updateMethod2(member);
		return "redirect:/exam03";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteMethod(@PathVariable(name = "id") int id) {			
	
		repository.deleteMethod(id);
		return "redirect:/exam03";
	}
}
