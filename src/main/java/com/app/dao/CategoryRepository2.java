package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Category;
import com.app.entities.SubCategory;

public interface CategoryRepository2 extends JpaRepository<SubCategory, Integer> {

	
	
}
