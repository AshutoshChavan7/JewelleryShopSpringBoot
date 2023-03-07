package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Authentication;
import com.app.entities.Customer;
import com.app.entities.Staff;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	@Query("SELECT m FROM Customer m WHERE m.athentication=?1")
	Customer findCustomerByAuthentication(Authentication athentication);

}
