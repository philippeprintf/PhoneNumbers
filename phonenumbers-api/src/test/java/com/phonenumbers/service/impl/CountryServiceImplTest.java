package com.phonenumbers.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.phonenumbers.enums.CountryEnum;

@RunWith(SpringJUnit4ClassRunner.class)
public class CountryServiceImplTest {
	
	@InjectMocks
	private CountryServiceImpl service;
	
	@Test
	public void testGetCountryNameList() {
		
		List<String> countryNames = service.getCountryNameList();

		assertEquals(countryNames.size(), CountryEnum.values().length);
	}

}
