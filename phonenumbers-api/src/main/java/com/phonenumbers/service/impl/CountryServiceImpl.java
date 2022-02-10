package com.phonenumbers.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.phonenumbers.enums.CountryEnum;
import com.phonenumbers.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Override
	public List<String> getCountryNameList() {
		return Arrays.asList(CountryEnum.values()).stream().map(CountryEnum::getName).collect(Collectors.toList());
	}

}
