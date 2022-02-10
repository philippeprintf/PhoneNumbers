package com.phonenumbers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phonenumbers.service.CountryService;

@RestController
@RequestMapping("/v1/country")
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@GetMapping("/getCountryNameList")
	public ResponseEntity<List<String>> getCountryList() {
		return ResponseEntity.ok(countryService.getCountryNameList());
	}
}
