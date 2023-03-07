package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.dao.CategoryRepository;
import com.app.dao.CategoryRepository2;
import com.app.dto.SubCategoryResponseDto;
import com.app.dto.SubCategorydto;
import com.app.entities.*;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService  {
	
	@Autowired
	CategoryRepository2 catrepo;
//
//	SubCategory sub=new SubCategory();
//	sub.setSubcategoryName(request.getSubcategoryName());
//	sub.setCategory(new Category(request.getCategory(), null));
	@Override
	public SubCategoryResponseDto insertCategory(SubCategorydto request) {
		// TODO Auto-generated method stub
		SubCategory sub=new SubCategory();
		sub.setSubcategoryName(request.getSubcategoryName());
		sub.setCategory(new Category(request.getCategory()));
		
		SubCategory persistedcategory= catrepo.save(sub);
		
		SubCategoryResponseDto reponse =new SubCategoryResponseDto();
		
	  BeanUtils.copyProperties(persistedcategory, reponse);
	  
	  return  reponse;
		
	}

}
