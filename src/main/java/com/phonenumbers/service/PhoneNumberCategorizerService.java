package com.phonenumbers.service;

import com.phonenumbers.dto.PhoneNumberDTO;

public interface PhoneNumberCategorizerService {
	
	PhoneNumberDTO categorize(String phoneNumber);
	
}
