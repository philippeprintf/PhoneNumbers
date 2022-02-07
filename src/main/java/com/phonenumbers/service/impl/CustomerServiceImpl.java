package com.phonenumbers.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonenumbers.dto.CustomerDTO;
import com.phonenumbers.dto.CustomerFiltersDTO;
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
	public List<CustomerDTO> findByFilters(CustomerFiltersDTO customerFiltersDTO) {
		
		List<CustomerDTO> customers = findAll();
		
		if (!StringUtils.isBlank(customerFiltersDTO.getCountryName())) {
			customers = customers.stream().filter(
					customer -> customer.getPhoneNumberDTO().getCountryDTO().getName().equalsIgnoreCase(customerFiltersDTO.getCountryName()))
					.collect(Collectors.toList());
		}
		
		if (!StringUtils.isBlank(customerFiltersDTO.getPhoneNumberState())) {
			Boolean isPhoneValid = "valid".equalsIgnoreCase(customerFiltersDTO.getPhoneNumberState());
			customers = customers.stream()
					.filter(customer -> isPhoneValid.equals(customer.getPhoneNumberDTO().isNumberValid()))
					.collect(Collectors.toList());
		}
		
		return customers;
	}
}
