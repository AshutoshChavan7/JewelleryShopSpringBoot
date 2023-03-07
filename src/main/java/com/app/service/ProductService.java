package com.app.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ProductDto;
import com.app.dto.ProductRespDto;
import com.app.entities.Category;
import com.app.entities.Product;
import com.app.entities.SubCategory;

public interface ProductService {
	
	List<Product> getAllProduct();
	SubCategory fetchSubCatrgoryDetails(Long subcategory_id) ; 
	
	Category fetchCatrgoryDetails(Long category_id);

	List<Product> fetcProductDetailsBySubCatrgoryId(SubCategory subCat) ;

	List<Product> fetcProductDetailsByCategoryAndSubCategoryId(Category cat, SubCategory subCat);

	ProductRespDto addProduct(ProductDto productdto);
	
	String saveImage(Long userId, MultipartFile imgFile) throws IOException;

	byte[] restoreImage(Long patId) throws IOException;
	
	public Product fetchProductById(Long prod_id);
	
//	byte[] restoreImage(Long patId) throws IOException;
	


	

}
