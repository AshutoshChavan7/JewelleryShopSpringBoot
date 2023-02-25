package com.app.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CustomerRepository;
import com.app.entities.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository repo;
	
	@Override
	public List<Customer> fetchAllCustomers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
