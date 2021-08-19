package com.challenge.justa.challengejusta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.justa.challengejusta.model.Champion;

public interface ChampionRepository extends JpaRepository<Champion, Long> {
	
}
