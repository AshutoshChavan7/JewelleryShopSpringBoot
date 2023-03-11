package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Ordar;
import com.app.entities.Product;

@Repository
public interface OrderRepository extends JpaRepository<Ordar, Long> {
	
	

}
