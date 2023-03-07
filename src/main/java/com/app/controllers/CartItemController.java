package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddCartDto;
import com.app.service.CartService;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartItemController {

	@Autowired
	CartService cartService;
	
	
//	@PostMapping("/add")
//	public ResponseEntity<?> addProductInCart(@RequestBody AddProductDto prodDto) throws ShoppingCartException {
//		log.info("In Shopping Cart controller : addProductInCart");
//		cartService.addProduct(prodDto.getProductId(), prodDto.getQuantity(), prodDto.getCustomerId());
//		return new ResponseEntity<>("Added sucessfully", HttpStatus.OK);
//
//	}
	@PostMapping("/add")
	public ResponseEntity<?> addToCart( @RequestBody AddCartDto addtc){
		
		
		cartService.addProduct(addtc.getProductId(), addtc.getCustomerId(), addtc.getQuantity());
		return new ResponseEntity<>("Added Sucessfully" , HttpStatus.OK);
	}
	
}
