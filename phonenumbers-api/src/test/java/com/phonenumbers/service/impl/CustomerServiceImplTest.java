package com.phonenumbers.service.impl;

import static com.phonenumbers.mock.CustomerMocker.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.phonenumbers.dto.CustomerDTO;
import com.phonenumbers.enums.CountryEnum;
import com.phonenumbers.mock.PhoneNumberMocker;
import com.phonenumbers.repository.CustomerRepository;
import com.phonenumbers.service.PhoneNumberCategorizerService;

@RunWith(SpringRunner.class)
public class CustomerServiceImplTest {
	
	@Mock
	private CustomerRepository customerRepository;
	
	@Mock
	private PhoneNumberCategorizerService phoneNumberCategorizerService;
	
	@InjectMocks
	private CustomerServiceImpl service;

	@Test
	public void testFindAll() {
		
		when(customerRepository.findAll()).thenReturn(CUSTOMER_ENTITY_LIST);
		
		List<CustomerDTO> customers = service.findAll();
		
		verify(phoneNumberCategorizerService, times(1)).categorize(anyString());
		assertNotNull(customers);
	}
	
	@Test
	public void testFindByFilters() {
		
		when(customerRepository.findAll()).thenReturn(CUSTOMER_ENTITY_LIST);
		when(phoneNumberCategorizerService.categorize(anyString())).thenReturn(PhoneNumberMocker.PHONE_NUMBER_CAMEROON_VALID_DTO);
		
		List<CustomerDTO> customers = service.findByFilters(CountryEnum.CAMEROON.getName(), "valid");
		
		customers.stream().forEach(customer -> {
			assertEquals(CountryEnum.CAMEROON.getName(), customer.getPhoneNumberDTO().getCountryDTO().getName());
			assertTrue(customer.getPhoneNumberDTO().isNumberValid());
		});
		
	}
	
	@Test
	public void testFindByFiltersEmpty() {
		
		when(customerRepository.findAll()).thenReturn(CUSTOMER_ENTITY_LIST);
		when(phoneNumberCategorizerService.categorize(anyString())).thenReturn(PhoneNumberMocker.PHONE_NUMBER_CAMEROON_VALID_DTO);
		
		List<CustomerDTO> customers = service.findByFilters(null, null);
		
		assertNotEquals(0, customers.size());
		
	}
}
