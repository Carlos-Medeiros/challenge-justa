package com.challenge.justa.challengejusta.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.challenge.justa.challengejusta.dto.PhoneDTO;
import com.challenge.justa.challengejusta.dto.UserDTO;
import com.challenge.justa.challengejusta.model.User;
import com.challenge.justa.challengejusta.repositories.UserRepository;

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
	public UserDTO searchName(String userName) {
		User user = userRepository.findByUserName(userName);
		user = userRepository.getById(user.getId());
		return new UserDTO(user);
	}
	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<User> list = userRepository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
	
	
	@Transactional
	public UserDTO register(UserDTO dto) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(dto.getPassword());
		User user = new User(null, dto.getUserName(), dto.getName(), encodedPassword, dto.getPhone());	
		
		RestTemplate restTemplate = new RestTemplate();

		
	    PhoneDTO phoneDTO = restTemplate.getForObject(
	    		"http://apilayer.net/api/validate?access_key=0e8614a7d82db89f02ebfa5ab4e0791d&number=" + user.getPhone() +"&country_code=BR&format=1", PhoneDTO.class);
		
		if (userRepository.findByUserName(dto.getUserName()) == null && phoneDTO.isValid()) {
			user = userRepository.save(user);
			return new UserDTO(user);
		}
		return new UserDTO(null);
	}
	
	@Transactional
	public UserDTO edit(UserDTO dto, Long id) {
		User user = userRepository.getById(id);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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
			String encodedPassword = encoder.encode(dto.getPassword());
			user.setPassword(encodedPassword);
		}
		if (dto.getPhone() == null) {
			user.getPhone();
		}
		else {
			RestTemplate restTemplate = new RestTemplate();

		    PhoneDTO phoneDTO = restTemplate.getForObject(
		    		"http://apilayer.net/api/validate?access_key=0e8614a7d82db89f02ebfa5ab4e0791d&number=" + dto.getPhone() +"&country_code=BR&format=1", PhoneDTO.class);
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
