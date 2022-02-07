package com.phonenumbers.dto;

import java.io.Serializable;

public class CustomerFiltersDTO implements Serializable {

	private static final long serialVersionUID = -5373879005577026391L;
	
	private String countryName;
	private String phoneNumberState;
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getPhoneNumberState() {
		return phoneNumberState;
	}
	public void setPhoneNumberState(String phoneNumberState) {
		this.phoneNumberState = phoneNumberState;
	}
	
}
