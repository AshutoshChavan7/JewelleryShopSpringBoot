package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.RegisterRequest;
import com.app.dto.SubCategorydto;
import com.app.dto.UserResponseDto;
import com.app.service.CategoryService;

@RestController 
@RequestMapping("/Category")
public class SubCategoryController {
	
	@Autowired(required=true)
	CategoryService catservice;
	
	@PostMapping("/insert")
	public ResponseEntity<?> addSubCategory(@RequestBody SubCategorydto request){
		
		System.out.println("in category registration"+request);
//		
           
//
	return ResponseEntity.ok(catservice.insertCategory(request));
		
	}

	
	
}
