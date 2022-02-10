package com.phonenumbers.strategy.impl;

import java.util.Arrays;
import java.util.Optional;

import com.phonenumbers.dto.PhoneNumberDTO;
import com.phonenumbers.enums.CountryEnum;
import com.phonenumbers.strategy.PhoneNumberCategorizerStrategy;

public class CategorizeByCountryCode implements PhoneNumberCategorizerStrategy {

	@Override
	public PhoneNumberDTO categorize(String phoneNumber) {
		
		PhoneNumberDTO phoneNumberDTO = new PhoneNumberDTO();
		phoneNumberDTO.setNumber(phoneNumber);
		
		if (phoneNumber != null) {
			
			Optional<CountryEnum> countryOptional = getCountryByPhoneNumber(phoneNumber);
			
			if (countryOptional.isPresent()) {
				phoneNumberDTO.setCountry(countryOptional.get().toCountryDTO());
				phoneNumberDTO.setNumberValid(phoneNumber.matches(countryOptional.get().getPhoneRegex()));
			}
			
		}
		
		return phoneNumberDTO;
	}
	
	private Optional<CountryEnum> getCountryByPhoneNumber(String phoneNumber) {
		return Arrays.asList(CountryEnum.values()).stream()
				.filter(country -> phoneNumber.startsWith("(" + country.getPhoneCode() + ")")).findFirst();
	}

}
