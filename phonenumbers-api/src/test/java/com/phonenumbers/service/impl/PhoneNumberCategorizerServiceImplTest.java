package com.phonenumbers.service.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.phonenumbers.dto.PhoneNumberDTO;
import com.phonenumbers.strategy.impl.CategorizeByCountryCode;

@RunWith(SpringRunner.class)
public class PhoneNumberCategorizerServiceImplTest {

	@InjectMocks
	private PhoneNumberCategorizerServiceImpl service;

	@Test
	public void testCategorize() {
		
		PhoneNumberDTO phoneNumberDTO = service.categorize("(212) 698054317", new CategorizeByCountryCode());
		
		assertNotNull(phoneNumberDTO);
	}
	
}
