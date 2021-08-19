package com.challenge.justa.challengejusta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.challenge.justa.challengejusta.dto.ChampionDTO;
import com.challenge.justa.challengejusta.dto.RegionDTO;
import com.challenge.justa.challengejusta.dto.UserDTO;
import com.challenge.justa.challengejusta.services.ChampionService;
import com.challenge.justa.challengejusta.services.UserService;

@RestController
@RequestMapping(value = "/champion")
public class ChampionController {

	@Autowired
	private ChampionService championService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/view/{id}")
	public ModelAndView search(ChampionDTO dto, @PathVariable Long id) {
		ModelAndView mv = new ModelAndView("viewChampion");
		dto = championService.search(id);
		mv.setViewName("champion/championDetails");
		mv.addObject("champion", dto);
		return mv;
	}
	
	@GetMapping("/home")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("allChampions");
		List<ChampionDTO> list = championService.findAll();
		mv.setViewName("champion/championHome");
		mv.addObject("champions", list);
		return mv;
	}
	
	@GetMapping("/add")
	public ModelAndView addHome() {
		ModelAndView mv = new ModelAndView("addChampions");
		RegionDTO[] region = championService.searchRegions();
		mv.setViewName("champion/addChampion");
		mv.addObject("regions", region);
		return mv;
	}
	
	@PostMapping("/add")
	public ModelAndView insert(ChampionDTO dto) {
		ModelAndView mv = new ModelAndView("registerChampion");
		dto = championService.insert(dto);
		mv.setViewName("champion/championHome");
		return mv;	
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editChampion(ChampionDTO dto, @PathVariable Long id) {
		ModelAndView mv = new ModelAndView("updateChampion");
		dto = championService.search(id);
		mv.setViewName("champion/editChampion");
		mv.addObject("champion", dto);
		return mv; 
	}
	
	@PostMapping("/edit/{id}")
	public ModelAndView putUser(ChampionDTO dto, @PathVariable Long id) {
		ModelAndView mv = new ModelAndView("update");
		dto = championService.update(dto, id);
		mv.setViewName("champion/championHome");
		return mv; 
	}
	
	
	@PostMapping("/delete/{id}")
	public ModelAndView deleteChampion(ChampionDTO dto, @PathVariable Long id) {
		ModelAndView mv = new ModelAndView("deleteChampion");
		dto = championService.delete(id);
		mv.setViewName("champion/championHome");
		return mv; 
	}

}
