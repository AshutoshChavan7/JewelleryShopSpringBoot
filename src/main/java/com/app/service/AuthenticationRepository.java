package com.app.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Authentication;
import com.app.entities.Manager;

@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {
	
	@Query("SELECT m FROM Authentication m WHERE m.mailId=?1")
	Authentication findAuthenticationByEmail( String mailId);

}
