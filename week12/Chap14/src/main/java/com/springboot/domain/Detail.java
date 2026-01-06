package com.springboot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
public class Detail {

	
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id") //공유양방향
    private Integer id;
	
    private String description;
    private float weight; 
    private float height;
    private float width;
	
    
    //양방향
   /*@OneToOne(mappedBy = "detail")    
   private Product product;
    */
    //공유양방향
    
    @OneToOne
    @JoinColumn(name = "product_id")  
    @MapsId 
    private Product product;
   
    
    
   
}
