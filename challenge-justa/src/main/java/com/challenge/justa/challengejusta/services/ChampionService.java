package com.challenge.justa.challengejusta.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.challenge.justa.challengejusta.dto.ChampionDTO;
import com.challenge.justa.challengejusta.dto.RegionDTO;
import com.challenge.justa.challengejusta.model.Champion;
import com.challenge.justa.challengejusta.repositories.ChampionRepository;

@Service
public class ChampionService {

	@Autowired
	private ChampionRepository championRepository;
	
	public RegionDTO[] searchRegions() {
		RestTemplate restTemplate = new RestTemplate();
		RegionDTO[] dto = restTemplate.getForObject(
	    		"https://thronesapi.com/api/v2/Continents/", RegionDTO[].class);
		return dto;
	}

	@Transactional
	public ChampionDTO search(Long id) {
		Champion champion = championRepository.getById(id);
		return new ChampionDTO(champion);
	}
	
	@Transactional(readOnly = true)
	public List<ChampionDTO> findAll() {
		List<Champion> list = championRepository.findAll();
		return list.stream().map(x -> new ChampionDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public ChampionDTO insert(ChampionDTO dto) {
		RestTemplate restTemplate = new RestTemplate();

		Champion champion = new Champion(null, dto.getName(), dto.getAge(), dto.getGender(), 
				dto.getHeight(), dto.getWeight(), dto.getStory(), dto.getRegion(), dto.getBreed(), 
				dto.getCategory(), dto.getLife(), dto.getSpeed(), dto.getDexterity(), dto.getStrength(),
				dto.getConstitution(), dto.getIntelligence(), dto.getSanity(), dto.getCharisma());
		
		RegionDTO regionDTO = restTemplate.getForObject(
	    		"https://thronesapi.com/api/v2/Continents/" + dto.getRegion(), RegionDTO.class);
		champion.setRegion(regionDTO.getName());

		champion = championRepository.save(champion);
				
		return new ChampionDTO(champion);
	}
	
	@Transactional
	public ChampionDTO update(ChampionDTO dto,Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Champion champion = championRepository.getById(id);
		
		champion.getId();
		
		if (dto.getName() == null) {
			champion.getName();
		} else {
			champion.setName(dto.getName());
		}
		
		if (dto.getAge() == null) {
			champion.getAge();
		} else {
			champion.setAge(dto.getAge());
		}
		
		if (dto.getGender() == null) {
			champion.getGender();
		} else {
			champion.setGender(dto.getGender());
		}
		
		if (dto.getHeight() == null) {
			champion.getHeight();
		} else {
			champion.setHeight(dto.getHeight());
		}
		
		if (dto.getWeight() == null) {
			champion.getWeight();
		} else {
			champion.setWeight(dto.getWeight());
		}
		
		if (dto.getStory() == null) {
			champion.getStory();
		} else {
			champion.setStory(dto.getStory());
		}
		
		if (dto.getRegion() == null) {
			champion.getRegion();
		} else {
			RegionDTO regionDTO = restTemplate.getForObject(
		    		"https://thronesapi.com/api/v2/Continents/" + dto.getRegion(), RegionDTO.class);
			champion.setRegion(regionDTO.getName());
		}
		
		if (dto.getBreed() == null) {
			champion.getBreed();
		} else {
			champion.setBreed(dto.getBreed());
		}
		
		if (dto.getCategory() == null) {
			champion.getCategory();
		} else {
			champion.setCategory(dto.getCategory());
		}
		
		if (dto.getLife() == null) {
			champion.getLife();
		} else {
			champion.setLife(dto.getLife());
		}
		
		if (dto.getSpeed() == null) {
			champion.getSpeed();
		} else {
			champion.setSpeed(dto.getSpeed());
		}
		
		if (dto.getDexterity() == null) {
			champion.getDexterity();
		} else {
			champion.setDexterity(dto.getDexterity());
		}
		
		if (dto.getStrength() == null) {
			champion.getStrength();
		} else {
			champion.setStrength(dto.getStrength());
		}
		
		if (dto.getConstitution() == null) {
			champion.getConstitution();
		} else {
			champion.setConstitution(dto.getConstitution());
		}
		
		if (dto.getIntelligence() == null) {
			champion.getIntelligence();
		} else {
			champion.setIntelligence(dto.getIntelligence());
		}
		
		if (dto.getSanity() == null) {
			champion.getSanity();
		} else {
			champion.setSanity(dto.getSanity());
		}
		
		if (dto.getCharisma() == null) {
			champion.getCharisma();
		} else {
			champion.setCharisma(dto.getCharisma());
		}

		champion = championRepository.save(champion);
		return new ChampionDTO(champion);
	}
	
	@Transactional
	public ChampionDTO delete(Long id) {
		championRepository.deleteById(id);
		return null;
	}
	
}
