package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Category;
import com.app.entities.SubCategory;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category getReferenceById(Long category);

	
	
}
