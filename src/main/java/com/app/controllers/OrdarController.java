package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.OrderByCartDto;
import com.app.service.OrderService;


@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrdarController {
	
	
	@Autowired
	private OrderService orderservice;

	@PostMapping(value ="/{id}")
	public ResponseEntity<?> placeOrderByCart(@PathVariable Long id) {
		//log.info("In Order Controller : place OrderBycart");
		List<OrderByCartDto> order = orderservice.createOrderByUserCart(id);
		return new ResponseEntity<>(order, HttpStatus.OK);
	}
	
}
