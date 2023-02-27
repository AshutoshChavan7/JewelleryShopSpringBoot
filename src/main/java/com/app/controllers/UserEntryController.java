package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.RegisterRequest;
import com.app.dto.UserResponseDto;
import com.app.service.UserServices;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/Register")
public class UserEntryController {
	
	@Autowired
	UserServices service;
	
	@PostMapping("/user")
	public ResponseEntity<?> userRegistration (@RequestBody RegisterRequest request){
		
		System.out.println("in user registration"+request);
		
	UserResponseDto response=service.RegisterUser(request);
	
	return ResponseEntity.ok(service.RegisterUser(request));
		
	}
	
	
	
	

}
