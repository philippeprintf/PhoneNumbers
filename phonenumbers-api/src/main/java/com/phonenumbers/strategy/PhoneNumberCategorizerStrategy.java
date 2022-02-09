package com.phonenumbers.strategy;

import com.phonenumbers.dto.PhoneNumberDTO;

public interface PhoneNumberCategorizerStrategy {
	
	PhoneNumberDTO categorize(String phoneNumber);

}
