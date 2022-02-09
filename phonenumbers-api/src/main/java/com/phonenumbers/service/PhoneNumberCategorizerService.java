package com.phonenumbers.service;

import com.phonenumbers.dto.PhoneNumberDTO;
import com.phonenumbers.strategy.PhoneNumberCategorizerStrategy;

public interface PhoneNumberCategorizerService {
	
	PhoneNumberDTO categorize(String phoneNumber, PhoneNumberCategorizerStrategy phoneNumberCategorizerStrategy);
	
}
