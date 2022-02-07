package com.phonenumbers.dto;

import java.io.Serializable;

public class CountryDTO implements Serializable {

	private static final long serialVersionUID = 1064509936982588900L;

	private String name;
	private String phoneCode;
	
	public CountryDTO(String name, String phoneCode) {
		this.setName(name);
		this.setPhoneCode(phoneCode);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}
	
}
