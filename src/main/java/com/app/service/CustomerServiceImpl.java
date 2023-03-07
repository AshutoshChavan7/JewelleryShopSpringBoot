package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CustomerRepository;
import com.app.dto.CustomerDto;
import com.app.dto.CustomerResponseDto;
import com.app.entities.Address;
import com.app.entities.Authentication;
import com.app.entities.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository repo;
	
	@Autowired
	AuthenticationRepository authrepo;
	
//	@Override
//	public List<Customer> fetchAllCustomers() {
//		// TODO Auto-generated method stub
//		return repo.findAll();
//	}

	

	@Override
	public Customer insertCustomer(CustomerDto cust) {
		Authentication auth=new Authentication();
		
		  System.out.println(cust);
		   auth.setPassword(cust.getPassword());
		   auth.setMailId(cust.getEmail());
		   auth.setRole("Customer");
		   
		 Authentication savedauth =  authrepo.save(auth);
		   
		   
		   Address address=new Address();
		   address.setCity(cust.getCity());
		   address.setState(cust.getState());
		   address.setZip(cust.getZip());
			
			
			
			Customer customer=new Customer();
			customer.setCustomerName(cust.getCustomerName());
			customer.setCotactNo(cust.getCotactNo());
			customer.setAddress(address);
			customer.setAthentication(savedauth);
			Customer cus =repo.save(customer);
		return	cus;
	}

}
