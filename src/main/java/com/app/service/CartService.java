package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.entities.CartItem;

public interface CartService {

	

	Long addProduct(Long productId, Long customerId, Long quantity);

	List<CartItem> listCartItems(Long id);

	void removeProduct(Long productId, Long customerId);

}
