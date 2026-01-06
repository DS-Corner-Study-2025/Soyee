package com.springboot.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import lombok.Data;


@Entity
@Data			// Getter Setter
//@Builder		// DTO -> Entity화
//@AllArgsConstructor	// 모든 컬럼 생성자 생성
//@NoArgsConstructor	// 기본 생성자
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    private String name;
   
    private int age;
   
    private String email;

	
    
	/*public Member(String name, int age, String email) {
		super();
	
		this.name = name;
		this.age = age;
		this.email = email;
	}   
	*/   
}