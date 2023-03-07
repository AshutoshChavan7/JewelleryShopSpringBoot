package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Product;
import com.app.entities.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

	SubCategory getReferenceById(Long subCategory_Id);

}
