package com.phonenumbers.service;

import java.util.List;

import com.phonenumbers.dto.CustomerDTO;

public interface CustomerService {

	List<CustomerDTO> findAll();
	List<CustomerDTO> findByFilters(String countryName, String phoneNumberState);

}
