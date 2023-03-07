package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.CartItem;
import com.app.entities.Category;
import com.app.entities.Customer;
import com.app.entities.Product;


public interface CartRepository extends JpaRepository<CartItem, Long>  {

	CartItem findByCustomerAndProduct(Customer customer, Product product);

}
