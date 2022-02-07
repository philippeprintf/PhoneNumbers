package com.phonenumbers.service.mock;

import java.util.Arrays;
import java.util.List;

import com.phonenumbers.dto.CustomerDTO;
import com.phonenumbers.dto.CustomerFiltersDTO;
import com.phonenumbers.enums.CountryEnum;
import com.phonenumbers.model.Customer;

public class CustomerMocker {
	
	public static final Customer CUSTOMER_ENTITY = mockCustomerCameroonValidEntity();
	public static final List<Customer> CUSTOMER_ENTITY_LIST = mockCustomerEntityList();
	public static final CustomerFiltersDTO CUSTOMER_FILTERS_CAMEROON_VALID_DTO = mockCustomerFiltersDTO(CountryEnum.CAMEROON.getName(), "valid");
	public static final CustomerDTO CUSTOMER_CAMEROON_VALID_DTO = mockCustomerCameroonValidDTO();
	
	private static List<Customer> mockCustomerEntityList() {
		return Arrays.asList(mockCustomerCameroonValidEntity());
	}
	
	private static Customer mockCustomerCameroonValidEntity() {
		Customer customer = new Customer();
		customer.setId(0L);
		customer.setName("EMILE CHRISTIAN KOUKOU DIKANDA HONORE ");
		customer.setPhone("(237) 697151594");
		return customer;
	}
	
	private static CustomerFiltersDTO mockCustomerFiltersDTO(String countryName, String phoneNumberState) {
		CustomerFiltersDTO customerFiltersDTO = new CustomerFiltersDTO();
		customerFiltersDTO.setCountryName(countryName);
		customerFiltersDTO.setPhoneNumberState(phoneNumberState);
		return customerFiltersDTO;
	}
	
	private static CustomerDTO mockCustomerCameroonValidDTO() {
		CustomerDTO customerDTO = new CustomerDTO(mockCustomerCameroonValidEntity());
		customerDTO.setPhoneNumberDTO(PhoneNumberMocker.PHONE_NUMBER_CAMEROON_VALID_DTO);
		return customerDTO;
	}


}

