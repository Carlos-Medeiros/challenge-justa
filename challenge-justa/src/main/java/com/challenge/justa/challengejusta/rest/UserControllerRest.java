package com.challenge.justa.challengejusta.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.justa.challengejusta.dto.UserDTO;
import com.challenge.justa.challengejusta.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserControllerRest {

	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> search(@PathVariable Long id) {
		UserDTO dto = userService.search(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping("/register")
	public ResponseEntity<UserDTO> register(@RequestBody UserDTO dto) {
		dto = userService.register(dto);
		return ResponseEntity.ok().body(dto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> update(@RequestBody UserDTO dto, @PathVariable Long id) {
		dto = userService.edit(dto, id);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		UserDTO dto = userService.search(id);
		userService.deleteUser(dto);
		return ResponseEntity.noContent().build();
	}
}
