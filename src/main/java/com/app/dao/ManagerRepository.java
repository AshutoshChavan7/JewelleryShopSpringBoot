package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entities.Authentication;
import com.app.entities.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
	
	
	
	
	
//	Manager findByathentication( Authentication athentication);;
	
	@Query("SELECT m FROM Manager m WHERE m.athentication=?1")
	Manager findManagerByAuthentication( Authentication athentication);

	

}
