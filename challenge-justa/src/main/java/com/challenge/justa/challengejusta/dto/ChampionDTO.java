package com.challenge.justa.challengejusta.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.challenge.justa.challengejusta.model.Champion;

public class ChampionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Integer age;
	private String gender;
	private Integer height;
	private Integer weight;
	private String story;
	private String region;
	private String breed;
	private String category;
	private Integer life;
	private Integer speed;
	private Integer dexterity;
	private Integer strength;
	private Integer constitution;
	private Integer intelligence;
	private Integer sanity;
	private Integer charisma;
		
	
	public ChampionDTO() {
	}

	public ChampionDTO(Long id, String name, Integer age, String gender, Integer height, Integer weight, String story,
			String region, String breed, String category, Integer life, Integer speed, Integer dexterity,
			Integer strength, Integer constitution, Integer intelligence, Integer sanity, Integer charisma) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.story = story;
		this.region = region;
		this.breed = breed;
		this.category = category;
		this.life = life;
		this.speed = speed;
		this.dexterity = dexterity;
		this.strength = strength;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.sanity = sanity;
		this.charisma = charisma;
	}

	public ChampionDTO(Champion entity) {
		id = entity.getId();
		name = entity.getName();
		age = entity.getAge();
		gender = entity.getGender();
		height = entity.getHeight();
		weight = entity.getWeight();
		story = entity.getStory();
		region = entity.getRegion();
		breed = entity.getBreed();
		category = entity.getCategory();
		life = entity.getLife();
		speed = entity.getSpeed();
		dexterity = entity.getDexterity();
		strength = entity.getStrength();
		constitution = entity.getConstitution();
		intelligence = entity.getIntelligence();
		sanity = entity.getSanity();
		charisma = entity.getCharisma();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getLife() {
		return life;
	}

	public void setLife(Integer life) {
		this.life = life;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public Integer getDexterity() {
		return dexterity;
	}

	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getConstitution() {
		return constitution;
	}

	public void setConstitution(Integer constitution) {
		this.constitution = constitution;
	}

	public Integer getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}

	public Integer getSanity() {
		return sanity;
	}

	public void setSanity(Integer sanity) {
		this.sanity = sanity;
	}

	public Integer getCharisma() {
		return charisma;
	}

	public void setCharisma(Integer charisma) {
		this.charisma = charisma;
	}


}
