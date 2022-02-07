package com.phonenumbers.enums;

import com.phonenumbers.dto.CountryDTO;

public enum CountryEnum {
	
	CAMEROON("Cameroon", "237", "\\(237\\)\\ ?[2368]\\d{7,8}$"),
	ETHIOPIA("Ethiopia", "251", "\\(251\\)\\ ?[1-59]\\d{8}$"),
	MOROCCO("Morocco", "212", "\\(212\\)\\ ?[5-9]\\d{8}$"),
	MOZAMBIQUE("Mozambique", "258", "\\(258\\)\\ ?[28]\\d{7,8}$"),
	UGANDA("Uganda", "256", "\\(256\\)\\ ?\\d{9}$");
	
	private final String name;
	private final String phoneCode;
	private final String phoneRegex;

	CountryEnum(String name, String phoneCode, String phoneRegex) {
		this.name = name;
		this.phoneCode = phoneCode;
		this.phoneRegex = phoneRegex;
	}

	public String getName() {
		return name;
	}

	public String getPhoneCode() {
		return phoneCode;
	}

	public String getPhoneRegex() {
		return phoneRegex;
	}
	
	public CountryDTO toCountryDTO() {
		return new CountryDTO(this.name, this.phoneCode);
	}
	
}
