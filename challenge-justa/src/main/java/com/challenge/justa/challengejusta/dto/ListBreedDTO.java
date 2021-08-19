package com.challenge.justa.challengejusta.dto;

public class ListBreedDTO {

	private Integer count;
	private BreedDTO[] results;
	
	public ListBreedDTO() {
	}	
	
	public ListBreedDTO(Integer count, BreedDTO[] results) {
		super();
		this.count = count;
		this.results = results;
	}
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public BreedDTO[] getResults() {
		return results;
	}
	public void setResults(BreedDTO[] results) {
		this.results = results;
	}
	
	
}
