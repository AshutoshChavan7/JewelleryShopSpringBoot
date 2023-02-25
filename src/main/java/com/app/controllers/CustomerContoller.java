package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Service.CustomerService;
import com.app.entities.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerContoller {
	
	@Autowired
	CustomerService service;
	
	@GetMapping("/display")
	public List<Customer> getAllCustomers()
	{
		return service.fetchAllCustomers();
		
	}
	
	

}
