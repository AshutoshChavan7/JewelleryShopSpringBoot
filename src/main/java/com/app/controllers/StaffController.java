package com.app.controllers;




import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ProductDto;
import com.app.dto.ProductRespDto;
import com.app.dto.StaffDto;
import com.app.dto.StaffResponseDto;
import com.app.entities.Customer;
import com.app.entities.Staff;
import com.app.service.CustomerService;
import com.app.service.StaffSevice;

@RestController
@CrossOrigin
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	StaffSevice service;
	
	
	@PostMapping("/add")
public ResponseEntity<?> addStaff(@RequestBody StaffDto staff){
		//System.out.println(staff.getManager());
		 StaffResponseDto response = service.addStaff(staff);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getall/{Id}")
	public List<Staff> getAllStaffs(@PathVariable Long Id){
		return service.getStaff(Id);
	}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<?> deleteStaff(@PathVariable Long Id){
		Staff stfStaff=service.removeStaff(Id);
		return new ResponseEntity<>(stfStaff, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateStaff(@RequestBody StaffDto Id){
		Staff stfStaff=service.editStaff(Id);
		return new ResponseEntity<>(stfStaff, HttpStatus.OK);
	}
	
	
}
