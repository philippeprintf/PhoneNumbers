package com.phonenumbers.service.impl;

import static com.phonenumbers.mock.CustomerMocker.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.phonenumbers.dto.CustomerDTO;
import com.phonenumbers.enums.CountryEnum;
import com.phonenumbers.mock.PhoneNumberMocker;
import com.phonenumbers.repository.CustomerRepository;
import com.phonenumbers.service.PhoneNumberCategorizerService;
import com.phonenumbers.strategy.PhoneNumberCategorizerStrategy;

@RunWith(SpringJUnit4ClassRunner.class)
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
		
		verify(phoneNumberCategorizerService, times(1)).categorize(anyString(), any(PhoneNumberCategorizerStrategy.class));
		assertNotNull(customers);
	}
	
	@Test
	public void testFindByFilters() {
		
		when(customerRepository.findAll()).thenReturn(CUSTOMER_ENTITY_LIST);
		when(phoneNumberCategorizerService.categorize(anyString(), any(PhoneNumberCategorizerStrategy.class))).thenReturn(PhoneNumberMocker.PHONE_NUMBER_CAMEROON_VALID_DTO);
		
		List<CustomerDTO> customers = service.findByFilters(CountryEnum.CAMEROON.getName(), "valid");
		
		customers.stream().forEach(customer -> {
			assertEquals(CountryEnum.CAMEROON.getName(), customer.getPhoneNumber().getCountry().getName());
			assertTrue(customer.getPhoneNumber().isNumberValid());
		});
		
	}
	
	@Test
	public void testFindByFiltersEmpty() {
		
		when(customerRepository.findAll()).thenReturn(CUSTOMER_ENTITY_LIST);
		when(phoneNumberCategorizerService.categorize(anyString(), any(PhoneNumberCategorizerStrategy.class))).thenReturn(PhoneNumberMocker.PHONE_NUMBER_CAMEROON_VALID_DTO);
		
		List<CustomerDTO> customers = service.findByFilters(null, null);
		
		assertNotEquals(0, customers.size());
		
	}
}
