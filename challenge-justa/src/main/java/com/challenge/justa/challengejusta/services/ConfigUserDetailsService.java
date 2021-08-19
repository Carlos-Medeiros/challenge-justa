package com.challenge.justa.challengejusta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.challenge.justa.challengejusta.config.ConfigUserDetails;
import com.challenge.justa.challengejusta.model.User;
import com.challenge.justa.challengejusta.repositories.UserRepository;

public class ConfigUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = repository.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new ConfigUserDetails(user);
	}

}
