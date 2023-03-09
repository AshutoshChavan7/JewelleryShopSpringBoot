package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ManagerResponseDto;
import com.app.dto.ProductRespDto;
import com.app.entities.Product;
import com.app.service.ManagerService;
import com.app.service.ProductService;


@RestController
@CrossOrigin
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private ProductService productService;
	@Autowired
	private  ManagerService manservice;
	
	@GetMapping("/main")
	public ResponseEntity<?> getAllProduct(){
		
		
		return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
		
	}
	
	@GetMapping("/allproducts/{managerId}")
	public ResponseEntity<?> getProductbyManagerId(@PathVariable Long managerId){
		
		
		ManagerResponseDto savedProd = manservice.getAllProduct(managerId);
		return new ResponseEntity<>(savedProd, HttpStatus.OK);
	}
	
	
	
}
