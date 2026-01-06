package com.springboot.domain;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private float price;
	
	//단방향
	
	/*@OneToOne(cascade = CascadeType.ALL)	
    @JoinColumn(name = "detail_id")
	private Detail detail;
*/
		
	//양방향
	
	 @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
	 @PrimaryKeyJoinColumn	 
	 private Detail detail;

	
	
	 
	 
}
