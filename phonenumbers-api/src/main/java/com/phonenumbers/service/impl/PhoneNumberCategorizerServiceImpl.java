package com.phonenumbers.service.impl;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.phonenumbers.dto.PhoneNumberDTO;
import com.phonenumbers.enums.CountryEnum;
import com.phonenumbers.service.PhoneNumberCategorizerService;

@Service
public class PhoneNumberCategorizerServiceImpl implements PhoneNumberCategorizerService {

	@Override
	public PhoneNumberDTO categorize(String phoneNumber) {
		
		PhoneNumberDTO phoneNumberDTO = new PhoneNumberDTO();
		phoneNumberDTO.setNumber(phoneNumber);
		
		Optional<CountryEnum> countryOptional = getCountryByPhoneNumber(phoneNumber);
		if (countryOptional.isPresent()) {
			phoneNumberDTO.setCountryDTO(countryOptional.get().toCountryDTO());
			phoneNumberDTO.setNumberValid(phoneNumber.matches(countryOptional.get().getPhoneRegex()));
		}
		
		return phoneNumberDTO;
		
	}

	private Optional<CountryEnum> getCountryByPhoneNumber(String phoneNumber) {
		return Arrays.asList(CountryEnum.values()).stream()
				.filter(country -> phoneNumber.startsWith("(" + country.getPhoneCode() + ")")).findFirst();
	}

}
