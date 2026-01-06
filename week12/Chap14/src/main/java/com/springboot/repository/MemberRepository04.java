package com.springboot.repository;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.springboot.domain.Member;

 
@Repository
public class MemberRepository04 {
    @PersistenceContext
    private EntityManager entityManager;
    
    
   	  public List<Member> selectMethod(){
   		String jpql = "SELECT entity FROM Member entity";
    	Query query = entityManager.createQuery(jpql);
    	List<Member>  member = query.getResultList();   
    	return member;
    }   	  
   	
		
	 public Member selectMethodById(int id) {
		 String jpql = "SELECT entity FROM Member entity WHERE id =:e_id";
		 Query query = entityManager.createQuery(jpql);
		 query.setParameter("e_id", id);
		 Member  member =(Member) query.getSingleResult();		
		 return member;
	 }
		
	
	 @Transactional
	 public void insertMethod(Member member) {		
		 String jpql = "INSERT INTO Member(name, age, email)  VALUES(:e_name, :e_age, :e_email)";
		 Query query = entityManager.createQuery(jpql);
		 query.setParameter("e_name", member.getName());
		 query.setParameter("e_age", member.getAge());
		 query.setParameter("e_email", member.getEmail());
		 query.executeUpdate();
		  
	 }
	 
	 @Transactional
	 public void updateMethod(Member member) {
		String jpql =  "UPDATE Member SET  name =:e_name, age =:e_age, email =:e_email WHERE id = :e_id";
			
		 Query query = entityManager.createQuery(jpql);
		 query.setParameter("e_name", member.getName());
		 query.setParameter("e_age", member.getAge());	
		 query.setParameter("e_email", member.getEmail());	
		 query.setParameter("e_id", member.getId());	
		 query.executeUpdate();
	 }
	
	 
	
	@Transactional	
	 public void deleteMethod(int id) {
		 String jpql = "DELETE FROM Member WHERE id = :e_id";
		 Query query = entityManager.createQuery(jpql);
		 query.setParameter("e_id", id);
		 query.executeUpdate();		 
	
	 };
	
    
}