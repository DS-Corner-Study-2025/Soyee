package com.springboot.domain;
import lombok.*;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  
    private String name;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
/*
    @Builder
    public TeamMember(Long id, String name, Team team) {
        this.id = id;
        this.name = name;
        this.team = team;
    }
    */
}
