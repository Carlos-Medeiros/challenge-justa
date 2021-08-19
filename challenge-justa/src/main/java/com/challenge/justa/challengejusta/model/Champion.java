package com.challenge.justa.challengejusta.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Champion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String name;
	@NotNull
	private Integer age;
	@NotBlank
	private String gender;
	@NotNull
	private Integer height;
	@NotNull
	private Integer weight;
	@NotBlank
	private String story;
	@NotBlank
	private String region;
	@NotBlank
	private String breed;
	@NotBlank
	private String category;
	
	@NotNull
	private Integer life;
	@NotNull
	private Integer speed;
	
	@NotNull
	private Integer dexterity;
	@NotNull
	private Integer strength;
	@NotNull
	private Integer constitution;
	@NotNull
	private Integer intelligence;
	@NotNull
	private Integer sanity;
	@NotNull
	private Integer charisma;
	
	public Champion() {
	}
	
	public Champion(Long id, @NotBlank String name, @NotNull Integer age, @NotBlank String gender,
			@NotNull Integer height, @NotNull Integer weight, @NotBlank String story, @NotBlank String region,
			@NotBlank String breed, @NotBlank String category, @NotNull Integer life, @NotNull Integer speed,
			@NotNull Integer dexterity, @NotNull Integer strength, @NotNull Integer constitution,
			@NotNull Integer intelligence, @NotNull Integer sanity, @NotNull Integer charisma) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Champion other = (Champion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}