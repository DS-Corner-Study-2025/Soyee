package com.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.domain.Detail;
import com.springboot.domain.Product;

 
@Repository
public interface DetailRepository extends JpaRepository<Detail, Integer> {
    	
    
}