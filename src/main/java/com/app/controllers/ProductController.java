package com.app.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Product;

import com.app.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	 ProductService productService;
	
	
	@GetMapping
	public ResponseEntity<?> getAllProduct(){
		
		
		return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
		
	}
	
//	@DeleteMapping("/{empId}")
//	public ApiResponse deleteEmpDetails(@PathVariable Long empId) {
//		System.out.println("in del emp " + empId);
//		return new ApiResponse(empService.deleteEmpDetails(empId));
//	}
	@GetMapping("/category/{category_id}")
	public ResponseEntity<?> getSubCategoryByCategory( @PathVariable Iterable<Integer> catId){
	
		return new ResponseEntity<>(productService.getSubCategoryByCategory( catId), HttpStatus.OK);
	}
	
	@GetMapping("/category/sub_category/{subcategory_id}")
	public ResponseEntity<?> getProductBySubCategory( @PathVariable Iterable<Integer> subCatId){
		
		return new ResponseEntity<>(productService.getProductBySubCategory(subCatId), HttpStatus.OK);
	}
	
//	@GetMapping("/sub_category/{subcategory_id}")
//	public List<Product> getProductDetailsByUserId(@PathVariable Long userId){
//		Product product = ProductService.fetchUserDetails(userId);
//		return ProductService.fetcProductDetailsByUserId(product);
//	}
}
