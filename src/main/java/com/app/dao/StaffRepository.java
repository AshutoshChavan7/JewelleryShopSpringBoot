package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.entities.Authentication;
import com.app.entities.Manager;
import com.app.entities.Staff;

public interface StaffRepository extends CrudRepository<Staff, Long>{
	
	//Staff findByathentication( Long athentication);
	
	@Query("SELECT m FROM Staff m WHERE m.manager=?1")
	List<Staff> getAllstaffByManager(Manager man);
	
	@Query("SELECT m FROM Staff m WHERE m.athentication=?1")
	Staff findStaffByAuthentication(Authentication athentication);

}
