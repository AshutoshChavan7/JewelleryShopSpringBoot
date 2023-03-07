package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddCartDto;
import com.app.dto.RemoveCartItemDto;
import com.app.entities.CartItem;
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
	// Add a request handling method for get list of cart items
//		@GetMapping("/{id}")
//		public ResponseEntity<?> getCartItemsList(@PathVariable("id") int id) {
//			log.info("In Shopping Cart controller : Get cart item list");
//			List<CartItem> cartitems = cartService.listCartItems(id);
//			return new ResponseEntity<>(cartitems, HttpStatus.OK);
//		}
//	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCartItemsList(@PathVariable("id") Long id){
		
		List<CartItem> cartitems = cartService.listCartItems(id);
		return new ResponseEntity<>(cartitems,  HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addToCart( @RequestBody AddCartDto addtc){
		
		
		cartService.addProduct(addtc.getProductId(), addtc.getCustomerId(), addtc.getQuantity());
		return new ResponseEntity<>("Added Sucessfully" , HttpStatus.OK);
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<?> removeItemsFromCart( @RequestBody RemoveCartItemDto info) {
		//log.info("In Shopping Cart controller : removeItemsFromCart");
		cartService.removeProduct(info.getProductId(), info.getCustomerId());
		return new ResponseEntity<>("item removed", HttpStatus.OK);

	}
}
