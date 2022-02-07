package com.phonenumbers.service.mock;

import com.phonenumbers.dto.CountryDTO;
import com.phonenumbers.enums.CountryEnum;

public class CountryMocker {

	public static CountryDTO COUNTRY_CAMEROON_DTO = mockCountryCameroonDTO();

	private static CountryDTO mockCountryCameroonDTO() {
		return new CountryDTO(CountryEnum.CAMEROON.getName(), CountryEnum.CAMEROON.getPhoneCode());
	}

}
