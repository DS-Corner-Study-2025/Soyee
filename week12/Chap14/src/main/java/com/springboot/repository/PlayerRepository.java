package com.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.domain.Player;


public interface PlayerRepository extends JpaRepository<Player, Long> {
}
