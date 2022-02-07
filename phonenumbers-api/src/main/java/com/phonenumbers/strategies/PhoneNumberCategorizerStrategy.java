package com.phonenumbers.strategies;

import com.phonenumbers.dto.PhoneNumberDTO;

public interface PhoneNumberCategorizerStrategy {
	
	void categorize(PhoneNumberDTO phoneNumberDTO);

}
