package com.app.service;

import java.util.List;

import com.app.entities.Product;
import com.app.entities.SubCategory;

public interface ProductService {
	
	List<Product> getAllProduct();



	List<Product> getProductBySubCategory(Iterable<Integer> subCatId);

	List<SubCategory> getSubCategoryByCategory(Iterable<Integer> catId);



	



	static List<Product> fetcProductDetailsByUserId(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
