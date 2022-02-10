package com.phonenumbers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phonenumbers.dto.CustomerDTO;
import com.phonenumbers.service.CustomerService;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<List<CustomerDTO>> findAll() {
		return ResponseEntity.ok(customerService.findAll());
	}
	
	@GetMapping("/findByFilters")
	public ResponseEntity<List<CustomerDTO>> findByFilters(@RequestParam(value = "countryName") String countryName,
			@RequestParam(value = "phoneNumberState") String phoneNumberState) {
		return ResponseEntity.ok(customerService.findByFilters(countryName, phoneNumberState));
	}

}
