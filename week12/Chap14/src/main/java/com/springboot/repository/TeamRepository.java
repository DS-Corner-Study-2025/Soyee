package com.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.domain.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
