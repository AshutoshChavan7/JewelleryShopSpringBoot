package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.app.entities.Category;
import com.app.entities.Product;
import com.app.entities.SubCategory;


public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findBySubCategory(SubCategory subCategory);  
	
//	List<Product> findBySubCategory(SubCategory sub_category_id);

	List<Product> findByCategoryAndSubCategory(Category category,SubCategory subCategory);
	
	List<Product> findByCategory(Category category);
	
}
