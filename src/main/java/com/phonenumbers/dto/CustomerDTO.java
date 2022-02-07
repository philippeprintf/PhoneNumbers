package com.phonenumbers.dto;

import java.io.Serializable;

import com.phonenumbers.model.Customer;

public class CustomerDTO implements Serializable {

	private static final long serialVersionUID = -5723796071212301529L;
	
	public CustomerDTO(Customer customer) {
		this.id = customer.getId();
		this.name = customer.getName();
	}
	
	private Long id;
	private String name;
	private PhoneNumberDTO phoneNumberDTO;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PhoneNumberDTO getPhoneNumberDTO() {
		return phoneNumberDTO;
	}
	public void setPhoneNumberDTO(PhoneNumberDTO phoneNumberDTO) {
		this.phoneNumberDTO = phoneNumberDTO;
	}
	
	
}
