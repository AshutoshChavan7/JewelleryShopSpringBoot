package com.app.controllers;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ProductDto;
import com.app.dto.ProductRespDto;
import com.app.dto.RegisterRequest;
import com.app.dto.SubCategoryResponseDto;
import com.app.dto.UserResponseDto;
import com.app.entities.Category;
import com.app.entities.Product;
import com.app.entities.SubCategory;

//import com.app.pojos.Note;
//import com.app.pojos.User;
import com.app.service.ProductService;

import io.swagger.v3.oas.models.responses.ApiResponse;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@GetMapping
	public ResponseEntity<?> getAllProduct(){
		
		
		return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
		
	}
	//@GetMapping(value={"/hr/worker/general/{id}","/hd/worker/general/{id}"})
	//@GetMapping(value= {"{category_id}","{sub_Category_id}"})
	@GetMapping("/{category_id}/{sub_Category_id}")	
	public List<Product> getProductDetailsByCategoryAndSubCategoryId(@PathVariable Long category_id ,@PathVariable Long sub_Category_id){
		SubCategory subCat = productService.fetchSubCatrgoryDetails(sub_Category_id);
		Category cat=productService.fetchCatrgoryDetails(category_id);
		return productService.fetcProductDetailsByCategoryAndSubCategoryId(cat,subCat);
	}


	@GetMapping("/sub_categoryid/{sub_Category_id}")
	public List<Product> getProductDetailsBySubCategoryId(@PathVariable Long sub_Category_id){
		SubCategory subCat = productService.fetchSubCatrgoryDetails(sub_Category_id);
		return productService.fetcProductDetailsBySubCatrgoryId(subCat);
	}

	
	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody ProductDto productdto){
		
		ProductRespDto savedProd = productService.addProduct(productdto);
		return new ResponseEntity<>(savedProd, HttpStatus.OK);
	}
//	@GetMapping(value = "{userId}/image", produces = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_GIF_VALUE,
//			MediaType.IMAGE_PNG_VALUE })
//	public ResponseEntity<?> getImage(@PathVariable Long userId) throws IOException {
//
//		return ResponseEntity.ok(productService.restoreImage(userId));
//	}
	
	@GetMapping(value = "{userId}/image", produces = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_GIF_VALUE,
			MediaType.IMAGE_PNG_VALUE })
	public ResponseEntity<?> getImage(@PathVariable Long userId) throws IOException {

		return ResponseEntity.ok(productService.restoreImage(userId));
	}
//	@PostMapping(value = "{userId}/image", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
//	public ResponseEntity<?> uploadImage(@PathVariable Long userId, @RequestBody MultipartFile imgFile)
//			throws IOException {
//		try {
//			return ResponseEntity.ok(productService.saveImage(userId, imgFile));
//		} catch (RuntimeException e) {
//			return new ResponseEntity<>(new ApiResponse(), HttpStatus.NOT_FOUND);
//		}
//	}
//	
	@PostMapping(value = "{productId}/image", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<?> uploadImage(@PathVariable Long productId, @RequestBody MultipartFile imgFile)
			throws IOException {
		try {
			return ResponseEntity.ok(productService.saveImage(productId, imgFile));
		} catch (RuntimeException e) {
			return new ResponseEntity<>(new ApiResponse(), HttpStatus.NOT_FOUND);
		}
	}
}
