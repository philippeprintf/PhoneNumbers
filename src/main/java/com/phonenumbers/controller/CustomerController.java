package com.phonenumbers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phonenumbers.dto.CustomerDTO;
import com.phonenumbers.dto.CustomerFiltersDTO;
import com.phonenumbers.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping()
	public ResponseEntity<List<CustomerDTO>> findAll() {
		return ResponseEntity.ok(customerService.findAll());
	}
	
	@GetMapping("/findByFilters")
	public ResponseEntity<List<CustomerDTO>> findAll(@RequestBody CustomerFiltersDTO customerFiltersDTO) {
		return ResponseEntity.ok(customerService.findByFilters(customerFiltersDTO));
	}

}
