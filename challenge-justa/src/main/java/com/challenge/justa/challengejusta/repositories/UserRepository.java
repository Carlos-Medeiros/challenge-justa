package com.challenge.justa.challengejusta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.justa.challengejusta.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUserName(String userName);
}
