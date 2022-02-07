package com.phonenumbers.service;

import java.util.List;

import com.phonenumbers.dto.CustomerDTO;
import com.phonenumbers.dto.CustomerFiltersDTO;

public interface CustomerService {

	List<CustomerDTO> findAll();
	List<CustomerDTO> findByFilters(CustomerFiltersDTO customerFiltersDTO);

}
