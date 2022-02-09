package com.phonenumbers.dto;

import java.io.Serializable;

public class PhoneNumberDTO implements Serializable {

	private static final long serialVersionUID = 153401947320480766L;
	
	private String number;
	private CountryDTO country;
	private boolean isNumberValid;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public CountryDTO getCountry() {
		return country;
	}
	public void setCountry(CountryDTO country) {
		this.country = country;
	}
	public boolean isNumberValid() {
		return isNumberValid;
	}
	public void setNumberValid(boolean isNumberValid) {
		this.isNumberValid = isNumberValid;
	}

}
