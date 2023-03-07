package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.CartItem;
import com.app.entities.Category;
import com.app.entities.Customer;
import com.app.entities.Product;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Long>  {

	CartItem findByCustomerAndProduct(Customer customer, Product product);

	List<CartItem> findByCustomer(Customer customer);

	Long deleteByCustomerAndProduct(Customer customer, Product product);

}
