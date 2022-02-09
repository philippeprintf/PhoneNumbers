package com.phonenumbers.mock;

import com.phonenumbers.dto.PhoneNumberDTO;

public class PhoneNumberMocker {

	public static final PhoneNumberDTO PHONE_NUMBER_CAMEROON_VALID_DTO = mockPhoneNumberCameroonValidDTO();
	
	private static PhoneNumberDTO mockPhoneNumberCameroonValidDTO() {
		PhoneNumberDTO phoneNumberDTO = new PhoneNumberDTO();
		phoneNumberDTO.setCountry(CountryMocker.COUNTRY_CAMEROON_DTO);
		phoneNumberDTO.setNumber(CustomerMocker.CUSTOMER_ENTITY.getPhone());
		phoneNumberDTO.setNumberValid(true);
		return phoneNumberDTO;
	}
}
