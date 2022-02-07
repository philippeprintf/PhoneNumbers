package com.phonenumbers.mock;

import java.util.Arrays;
import java.util.List;

import com.phonenumbers.dto.CustomerDTO;
import com.phonenumbers.model.Customer;

public class CustomerMocker {
	
	public static final Customer CUSTOMER_ENTITY = mockCustomerCameroonValidEntity();
	public static final List<Customer> CUSTOMER_ENTITY_LIST = mockCustomerEntityList();
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
	
	private static CustomerDTO mockCustomerCameroonValidDTO() {
		CustomerDTO customerDTO = new CustomerDTO(mockCustomerCameroonValidEntity());
		customerDTO.setPhoneNumberDTO(PhoneNumberMocker.PHONE_NUMBER_CAMEROON_VALID_DTO);
		return customerDTO;
	}


}

