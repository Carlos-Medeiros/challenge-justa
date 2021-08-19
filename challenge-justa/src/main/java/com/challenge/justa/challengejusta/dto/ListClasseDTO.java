package com.challenge.justa.challengejusta.dto;

public class ListClasseDTO {

	private Integer count;
	private ClasseDTO[] results;
	
	public ListClasseDTO() {

	}
	
	public ListClasseDTO(Integer count, ClasseDTO[] results) {
		this.count = count;
		this.results = results;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public ClasseDTO[] getResults() {
		return results;
	}

	public void setResults(ClasseDTO[] results) {
		this.results = results;
	}
	
	
	
}
