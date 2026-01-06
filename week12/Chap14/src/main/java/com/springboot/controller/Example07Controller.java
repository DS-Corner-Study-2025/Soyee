package com.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;



import java.util.List;
import java.util.ArrayList;

import com.springboot.domain.Detail;
import com.springboot.domain.Player;
import com.springboot.domain.Product;
import com.springboot.domain.Team;
import com.springboot.repository.PlayerRepository;
import com.springboot.repository.TeamRepository;

@Controller
@RequestMapping("/exam07")
public class Example07Controller {
	
		
	 @Autowired 
	 private TeamRepository teamRepository;
	 
	 
	 @Autowired 
	 private PlayerRepository playerRepository;
	
	@GetMapping
	public String requestInsert(Model model) {	
		Team team = new Team();
		team.setName("축구팀");
		teamRepository.save(team); 		
		
		
		Player player = new Player();
		player.setName("홍길순");
		player.setTeam(team);		
		
		
		playerRepository.save(player);
		
	//	teamRepository.save(team);
		
		
                
		     
		 Iterable<Player> playerList = playerRepository.findAll();		
	        Iterable<Team> teamList = teamRepository.findAll();	
	        model.addAttribute("playerList",playerList);
	        model.addAttribute("teamList", teamList);
	        
		return "viewPage07";
	}
	
	
	
}