package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CustomerDto;
import com.app.dto.CustomerResponseDto;
import com.app.entities.Address;
import com.app.entities.Authentication;
import com.app.entities.Customer;
import com.app.service.CustomerService;



@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerContoller {
	
	@Autowired
	CustomerService service;
	
//	@GetMapping("/display")
//	public List<Customer> getAllCustomers()
//	{
//		return service.fetchAllCustomers();
//		
//	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addCustomer(@RequestBody CustomerDto cust) {
		
		
		Customer cusres = service.insertCustomer(cust);
		
		return new ResponseEntity<>(cusres, HttpStatus.OK);
		//return service.insertCustomer(customer);
	}
	

}
