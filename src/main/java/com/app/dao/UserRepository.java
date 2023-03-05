package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Authentication;

@Repository
public interface UserRepository extends JpaRepository<Authentication, Integer> {
	
	
	Optional<Authentication> findBymailId(String username);
	
	@Modifying
	@Query("update User u set u.password = ?2 where u.email = ?1")
	int updatePasswordByEmail(String email, String password);
	

	
}
