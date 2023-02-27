package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CategoryRepository;
import com.app.dao.ProductRepository;
import com.app.entities.Product;
import com.app.entities.SubCategory;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository prodRepo;
	
	@Autowired
	private CategoryRepository catRepo;

	@Override
	public List<Product> getAllProduct() {
		
		return prodRepo.findAll();
	}


	@Override
	public List<Product> getProductBySubCategory(Iterable<Integer> subCatId) {
		
		return prodRepo.findAllById(subCatId);
	}

	
	@Override
	public List<SubCategory> getSubCategoryByCategory(Iterable<Integer> catId) {
		// TODO Auto-generated method stub
		return catRepo.findAllById(catId);
	}



	
	
	
}
