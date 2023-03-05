package com.app.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Authentication;

public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {

}
