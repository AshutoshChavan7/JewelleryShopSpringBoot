package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.ProductService;

@RestController
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/main")
	public ResponseEntity<?> getAllProduct(){
		
		
		return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
		
	}
	
}
