package com.challenge.justa.challengejusta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.challenge.justa.challengejusta.dto.UserDTO;
import com.challenge.justa.challengejusta.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("user");
		List<UserDTO> dto = userService.findAll();
		mv.setViewName("home/home");
		mv.addObject("users", dto);
		return mv;
	}
	
	@GetMapping("/")
	public ModelAndView search() {
		ModelAndView mv = new ModelAndView("user");
		mv.setViewName("register/register");
		return mv;
	}
	
	@PostMapping("/register")
	public ModelAndView register(UserDTO dto) {
		ModelAndView mv = new ModelAndView("register");
		dto = userService.register(dto);
		mv.setViewName("register/registerSuccessful");
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editUser(UserDTO dto, @PathVariable Long id) {
		ModelAndView mv = new ModelAndView("update");
		dto = userService.search(id);
		mv.setViewName("home/editUser");
		mv.addObject("user", dto);
		return mv; 
	}
	
	@PostMapping("/edit/{id}")
	public ModelAndView putUser(UserDTO dto, @PathVariable Long id) {
		ModelAndView mv = new ModelAndView("update");
		dto = userService.edit(dto,id);
		mv.setViewName("home/home");
		return mv; 
	}
	
	
	@PostMapping("/delete")
	public ModelAndView deleteUser(UserDTO dto) {
		ModelAndView mv = new ModelAndView("update");
		 dto = userService.deleteUser(dto);
		mv.setViewName("home/home");
		return mv; 
	}
	
}
