package com.springboot.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;




import com.springboot.domain.Product;
import com.springboot.domain.Detail;
import com.springboot.domain.Member;
import com.springboot.repository.DetailRepository;
import com.springboot.repository.ProductRepository;



import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Controller
@RequestMapping("/exam05")
public class Example05Controller {
	
	 @Autowired 
	 private ProductRepository productRepository; 
	
	 @Autowired 
	 private DetailRepository detailRepository; 
	 
	@GetMapping
	public String requestInsert(Model model) {				
		
		 Product product = new Product();		  
		 product.setName("갤럭시 24+");   
		 product.setPrice(999);  
		 
		Detail detail = new Detail();         
        detail.setDescription("삼성 안드로이드폰");
        detail.setWeight(196f);
        detail.setHeight(158.5f);       
        detail.setWidth(75.9f);
        
        
        product.setDetail(detail);        
        productRepository.save(product);
		
		
        Iterable<Product> productList = productRepository.findAll();		
        Iterable<Detail> detailList = detailRepository.findAll();	
        model.addAttribute("productList",productList);
        model.addAttribute("detailList", detailList);
        
		return "viewPage05";
	}	
}