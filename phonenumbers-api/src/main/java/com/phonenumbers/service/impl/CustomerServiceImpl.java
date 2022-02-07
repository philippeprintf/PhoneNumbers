package com.phonenumbers.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonenumbers.dto.CustomerDTO;
import com.phonenumbers.model.Customer;
import com.phonenumbers.repository.CustomerRepository;
import com.phonenumbers.service.CustomerService;
import com.phonenumbers.service.PhoneNumberCategorizerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PhoneNumberCategorizerService phoneNumberCategorizerService;
	
	@Override
	public List<CustomerDTO> findAll() {
		List<Customer> customers = customerRepository.findAll();
		return customers.stream().map(this::buildDTO).collect(Collectors.toList());
	}

	private CustomerDTO buildDTO(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO(customer);
		customerDTO.setPhoneNumberDTO(phoneNumberCategorizerService.categorize(customer.getPhone()));
		return customerDTO;
	}

	@Override
	public List<CustomerDTO> findByFilters(String countryName, String phoneNumberState) {
		
		List<CustomerDTO> customers = findAll();
		
		if (!StringUtils.isBlank(countryName)) {
			customers = customers.stream().filter(
					customer -> customer.getPhoneNumberDTO().getCountryDTO().getName().equalsIgnoreCase(countryName))
					.collect(Collectors.toList());
		}
		
		if (!StringUtils.isBlank(phoneNumberState)) {
			Boolean isPhoneValid = "valid".equalsIgnoreCase(phoneNumberState);
			customers = customers.stream()
					.filter(customer -> isPhoneValid.equals(customer.getPhoneNumberDTO().isNumberValid()))
					.collect(Collectors.toList());
		}
		
		return customers;
	}
}
