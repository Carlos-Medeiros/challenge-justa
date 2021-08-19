package com.challenge.justa.challengejusta.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.challenge.justa.challengejusta.model.User;

public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String userName;
	private String name;
	private String password;
	private String phone;
	
	public UserDTO() {
	}
	
	public UserDTO(Long id, String userName, String name, String password, String phone) {
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.password = password;
		this.phone = phone;
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		userName = entity.getUserName();
		name = entity.getName();
		password = entity.getPassword();
		phone = entity.getPhone();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

		

}