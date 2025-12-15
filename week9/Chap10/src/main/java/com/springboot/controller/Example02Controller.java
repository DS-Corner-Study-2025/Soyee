package com.springboot.controller;

import java.security.Principal;

import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Collection;
import java.util.Iterator;

@Controller
public class Example02Controller {
	 @GetMapping("/exam02")
	 public String requestMethod(Model model) {	 
		 
		 return "redirect:/member/user";
	 }	 
	
	 @GetMapping("/member/user")
	 public String requestMethod2(Authentication authentication, Model model) {
		 UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		 String username = userDetails.getUsername();
		 String password  = userDetails.getPassword();		
		 Boolean isAuthentication  = authentication.isAuthenticated();
		 
		 model.addAttribute("data1", "/manager/user");
		 model.addAttribute("data2", username);	
		 model.addAttribute("data3", password);
		
		 
		Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();		
		for (GrantedAuthority item : authorities ) {				
			  model.addAttribute("data4", item+ " ");	
	      }
		 model.addAttribute("data5", isAuthentication);
		 
		 return "viewPage02";
	    
	 }
	 
	/* @GetMapping("/member/user")
	 public String principalMethod(Principal principal, Model model) {
		 String username = principal.getName(); 
		 
		 model.addAttribute("data1", "/member/user");
		 model.addAttribute("data2", username);				
		 return "viewPage02";
	 }

	 @GetMapping("/member/user")
	 public String authenticationMethod1(Authentication authentication, Model model) {
		 String username = authentication.getName();
		 
		 model.addAttribute("data1", "/member/user");
		 model.addAttribute("data2", username);		
		 return "viewPage02";
	    
	 }
	
	 @GetMapping("/member/user")
	 public String authenticationMethod2(Authentication authentication, Model model) {
		 UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		 String username = userDetails.getUsername();
		 String password  = userDetails.getPassword();
		 String authoritiy  = authentication.getName();
		 
		 model.addAttribute("data1", "/member/user");
		 model.addAttribute("data2", username);	
		 model.addAttribute("data3", password);
		 model.addAttribute("data4", authoritiy);		 
		
		 return "viewPage02";
	    
	 }
	
	 
	 @GetMapping("/manager/user")
	 public String anotationMethod5(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		// UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		 model.addAttribute("data1", "/member/user");
		 model.addAttribute("data2", userDetails.getUsername());	
		 model.addAttribute("data3", userDetails.getPassword());	
		 model.addAttribute("data4", userDetails.getAuthorities());		
		 return "viewPage02";
	    
	 }
	 @GetMapping("/member/user")
	 public String securityContextHolderMethod(Model model) {		 
		 
		 SecurityContext context = SecurityContextHolder.getContext();
		 Authentication authentication = context.getAuthentication();
		 
		 String username = authentication.getName();
		 Object principal = authentication.getPrincipal();		 
		 
		 Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();		
		
		 model.addAttribute("data1", "/member/user");
		 model.addAttribute("data2", username );		
		 model.addAttribute("data3", principal.toString());	
		 model.addAttribute("data4", authentication.getAuthorities());	
		
		 for (GrantedAuthority item : authorities ) {
			 
			
			  model.addAttribute("data4", item+ " ");	
	      }
	
			
		 return "viewPage02";
	 }
	 */
}
