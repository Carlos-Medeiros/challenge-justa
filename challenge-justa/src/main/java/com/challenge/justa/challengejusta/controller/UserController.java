package com.challenge.justa.challengejusta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.challenge.justa.challengejusta.dto.UserDTO;
import com.challenge.justa.challengejusta.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public ModelAndView search(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("user");
		UserDTO dto = userService.search(id);
		mv.setViewName("home/home");
		mv.addObject("user", dto);
		return mv;
	}
	
	@GetMapping("/register")
	public ModelAndView search() {
		ModelAndView mv = new ModelAndView("user");
		mv.setViewName("register/register");
		return mv;
	}
	
	@PostMapping("/register")
	public ModelAndView register(UserDTO dto) {
		ModelAndView mv = new ModelAndView("register");
		dto = userService.register(dto);
		mv.setViewName("home/home");
		mv.addObject("user", dto);
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
	
	@PostMapping("/edit")
	public ModelAndView putUser(UserDTO dto) {
		ModelAndView mv = new ModelAndView("update");
		dto = userService.edit(dto);
		mv.setViewName("home/home");
		mv.addObject("user", dto);
		return mv; 
	}
	
	
	@PostMapping("/delete")
	public ModelAndView deleteUser(UserDTO dto) {
		ModelAndView mv = new ModelAndView("update");
		 dto = userService.deleteUser(dto);
		mv.setViewName("register/register");
		return mv; 
	}
	
}
