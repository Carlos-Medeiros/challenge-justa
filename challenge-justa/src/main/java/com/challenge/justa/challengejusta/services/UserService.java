package com.challenge.justa.challengejusta.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.challenge.justa.challengejusta.dto.PhoneDTO;
import com.challenge.justa.challengejusta.dto.UserConfigDTO;
import com.challenge.justa.challengejusta.dto.UserDTO;
import com.challenge.justa.challengejusta.model.User;
import com.challenge.justa.challengejusta.repositories.UserRepository;
import com.challenge.justa.challengejusta.util.Util;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public UserDTO search(Long id) {
		User user = userRepository.getById(id);
		return new UserDTO(user);
	}
	
	@Transactional
	public UserConfigDTO searchUserConfig(Long id) {
		User user = userRepository.getById(id);
		return new UserConfigDTO(user);
	}
	
	@Transactional
	public UserConfigDTO searchUserConfigName(String userName) {
		User user = userRepository.findByUserName(userName);
		return new UserConfigDTO(user);
	}
	
	
	
	@Transactional
	public UserDTO register(UserDTO dto) {
		User user = new User(null, dto.getUserName(), dto.getName(), Util.md5(dto.getPassword()), dto.getPhone());	
		
		RestTemplate restTemplate = new RestTemplate();

		
	    PhoneDTO phoneDTO = restTemplate.getForObject(
	    		"http://apilayer.net/api/validate?access_key=a7982d8f6313b428afdbce2bd9d1f922&number=" + user.getPhone() +"&country_code=BR&format=1", PhoneDTO.class);

		
		if (userRepository.findByUserName(dto.getUserName()) == null && phoneDTO.isValid()) {
			user = userRepository.save(user);
			return new UserDTO(user);
		}
		return new UserDTO(null);
	}
	
	@Transactional
	public UserDTO edit(UserDTO dto) {
		User user = userRepository.getById(dto.getId());
		user.getId();

		if (dto.getUserName() == null) {
			user.getUserName();
		} else {
			user = userRepository.findByUserName(dto.getUserName());
			if (user != null) {
				user.setUserName(dto.getUserName());
			} else {
				user.getUserName();
			}
		}
		if (dto.getName() == null) {
			user.getName();
		}
		else {
			user.setName(dto.getName());
		}
		if (dto.getPassword() == null) {
			user.getPassword();
		} else {
			user.setPassword(Util.md5(dto.getPassword()));
		}
		if (dto.getPhone() == null) {
			user.getPhone();
		}
		else {
			RestTemplate restTemplate = new RestTemplate();

		    PhoneDTO phoneDTO = restTemplate.getForObject(
		    		"http://apilayer.net/api/validate?access_key=a7982d8f6313b428afdbce2bd9d1f922&number=" + dto.getPhone() +"&country_code=BR&format=1", PhoneDTO.class);
		    if (phoneDTO.isValid()) {
				user.setPhone(dto.getPhone());
		    } else {
		    	user.getPhone();
		    }
		}

		user = userRepository.save(user);
		return new UserDTO(user);
	}
		
	@Transactional
	public UserDTO deleteUser(UserDTO dto) {
		userRepository.deleteById(dto.getId());
		return null;
	}
	
}
