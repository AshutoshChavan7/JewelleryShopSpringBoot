package com.app.controllers;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Customer;
import com.app.entities.Staff;
import com.app.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class StaffController {

	@Autowired
	CustomerService service;
	
	@GetMapping("/staff")
	public Staff getCustomerDetails() {
		return null;
	}
	
}
