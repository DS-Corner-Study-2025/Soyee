package com.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.domain.Member;

@Repository
public interface MemberRepository02 extends JpaRepository<Member, Integer> {	
	 	 
}