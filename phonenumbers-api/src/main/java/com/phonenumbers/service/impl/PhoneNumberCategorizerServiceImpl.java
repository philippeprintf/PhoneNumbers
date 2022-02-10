package com.phonenumbers.service.impl;

import org.springframework.stereotype.Service;

import com.phonenumbers.dto.PhoneNumberDTO;
import com.phonenumbers.service.PhoneNumberCategorizerService;
import com.phonenumbers.strategy.PhoneNumberCategorizerStrategy;

@Service
public class PhoneNumberCategorizerServiceImpl implements PhoneNumberCategorizerService {
	
	@Override
	public PhoneNumberDTO categorize(String phoneNumber, PhoneNumberCategorizerStrategy strategy) {
		return strategy.categorize(phoneNumber);
	}

}
