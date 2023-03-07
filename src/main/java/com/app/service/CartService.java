package com.app.service;

import org.springframework.http.ResponseEntity;

public interface CartService {

	

	Long addProduct(Long productId, Long customerId, Long quantity);

}
