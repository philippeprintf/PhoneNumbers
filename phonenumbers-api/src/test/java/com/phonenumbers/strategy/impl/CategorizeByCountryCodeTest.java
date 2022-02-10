package com.phonenumbers.strategy.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.phonenumbers.dto.PhoneNumberDTO;

@RunWith(SpringRunner.class)
public class CategorizeByCountryCodeTest {
	
	@InjectMocks
	private CategorizeByCountryCode strategy;

	@Test
	public void testCategorizeValidNumber() {
		
		PhoneNumberDTO phoneNumberDTO = strategy.categorize("(212) 698054317");
		
		assertTrue(phoneNumberDTO.isNumberValid());
	}
	
	@Test
	public void testCategorizeInvalidNumber() {
		
		PhoneNumberDTO phoneNumberDTO = strategy.categorize("(212) 6007989253");
		
		assertFalse(phoneNumberDTO.isNumberValid());
	}
	
	@Test
	public void testCategorizeCountryNotFound() {
		
		PhoneNumberDTO phoneNumberDTO = strategy.categorize("(-1) 6007989253");
		
		assertNull(phoneNumberDTO.getCountry());
		assertFalse(phoneNumberDTO.isNumberValid());
	}
	
	@Test
	public void testCategorizeNull() {
		
		PhoneNumberDTO phoneNumberDTO = strategy.categorize(null);
		
		assertNull(phoneNumberDTO.getCountry());
		assertFalse(phoneNumberDTO.isNumberValid());
	}
}
