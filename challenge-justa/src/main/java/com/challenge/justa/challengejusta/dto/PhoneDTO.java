package com.challenge.justa.challengejusta.dto;

public class PhoneDTO {

    private String number;
	private boolean valid;
	
	public PhoneDTO() {
	}
	
	public PhoneDTO(String number, boolean valid) {
		this.number = number;
		this.valid = valid;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
