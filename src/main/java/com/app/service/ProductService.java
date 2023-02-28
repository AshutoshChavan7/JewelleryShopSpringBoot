package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.ProductDto;
import com.app.dto.ProductRespDto;
import com.app.entities.Product;
import com.app.entities.SubCategory;

public interface ProductService {
	
	List<Product> getAllProduct();
	SubCategory fetchSubCatrgoryDetails(Long subcategory_id) ; 

	List<Product> fetcProductDetailsBySubCatrgoryId(SubCategory subCat) ;

	ProductRespDto addProduct(ProductDto productdto);


  

	


	

}
