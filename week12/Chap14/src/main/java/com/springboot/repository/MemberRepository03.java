package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.domain.Member;

import jakarta.transaction.Transactional;
@Repository
public interface MemberRepository03 extends JpaRepository<Member, Integer> {	
	 
	@Transactional
	// @Modifying 
	 @Query(value = "SELECT entity FROM Member entity")
	//@Query(value = "SELECT * FROM Member", nativeQuery=true) 
	 public List<Member> selectMethod();
	
	
	 @Transactional
	 //@Modifying 
	 @Query(value = "SELECT entity FROM Member entity WHERE id = :e_id")
	 //@Query(value = "SELECT * FROM Member WHERE id = ?", nativeQuery=true) 
	 public Member  selectMethodById(@Param("e_id") int id);	
		
	
	 
	 @Transactional
	 @Modifying 
	@Query(value = "INSERT INTO Member(name, age, email)  VALUES(:e_name, :e_age, :e_email)")
	 // @Query(value = "INSERT INTO Member(name, age, email) VALUES(?,?,?)", nativeQuery=true) 
	 public int insertMethod(@Param("e_name") String name, @Param("e_age") int age, @Param("e_email") String email);
	
	 @Transactional
	 @Modifying 
	@Query(value = "INSERT INTO Member(name, age, email)  VALUES(:#{#entity.name}, :#{#entity.age}, :#{#entity.email})")
	  
	 public int insertMethod2(@Param("entity") Member member);

	 
	 
	 @Transactional
	 @Modifying 
	 @Query(value = "UPDATE Member SET  name =:e_name, age =:e_age, email =:e_email WHERE id = :e_id")
	 // @Query(value = "UPDATE Member SET  name =?, age =?, email =? WHERE id = ?", nativeQuery=true)
	 public int updateMethod(@Param("e_name") String name, @Param("e_age") int age, @Param("e_email") String email, @Param("e_id") int id);
	 
	 
	 
	 @Transactional
	 @Modifying 
	 @Query(value = "UPDATE Member SET  name =:#{#entity.name}, age =:#{#entity.age}, email =:#{#entity.email} WHERE id = :#{#entity.id}")	
	 public int updateMethod2(@Param("entity") Member member);
	 
	
	 
	 
	 @Transactional
	 @Modifying 
	 @Query(value = "DELETE FROM Member WHERE id = :e_id")
	//@Query(value = "DELETE FROM Member WHERE id = ?", nativeQuery=true) 
	 public int deleteMethod(@Param("e_id") int id);
	
	 
	 
	 
	 
	 
}