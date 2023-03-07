package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.dto.CustomerDto;
import com.app.dto.CustomerResponseDto;
import com.app.entities.Customer;


public interface CustomerService {
	
	//List<Customer> fetchAllCustomers();
	
//	Customer insertCustomer(Customer cust);
	
	Customer insertCustomer(CustomerDto cust);

}
