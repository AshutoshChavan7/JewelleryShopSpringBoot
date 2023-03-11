package com.app.service;

import java.util.List;

import com.app.dto.OrderByCartDto;

public interface OrderService {

	List<OrderByCartDto> createOrderByUserCart(Long custId);

}
