package com.app.service;

import org.springframework.http.ResponseEntity;

import com.app.dto.SubCategoryResponseDto;
import com.app.dto.SubCategorydto;

public interface CategoryService {
	
	SubCategoryResponseDto insertCategory(SubCategorydto request);

}
