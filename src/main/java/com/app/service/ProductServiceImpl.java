package com.app.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;

import com.app.dao.CategoryRepository;
import com.app.dao.ProductRepository;
import com.app.dao.SubCategoryRepository;

import com.app.dto.ProductDto;
import com.app.dto.ProductRespDto;
import com.app.dto.RegisterRequest;
import com.app.dto.SubCategoryResponseDto;
import com.app.dto.SubCategorydto;
import com.app.dto.UserResponseDto;
import com.app.entities.Authentication;
import com.app.entities.Category;

import com.app.entities.Product;
import com.app.entities.SubCategory;



@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository prodRepo;
	
	@Autowired
	private CategoryRepository catRepo;
	
	@Autowired
	private SubCategoryRepository subCatRepo;

	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<Product> getAllProduct() {
		
		return prodRepo.findAll();
	}


	@Override
	public SubCategory fetchSubCatrgoryDetails(Long subCategory_id) {
	
		return subCatRepo.findById(subCategory_id).orElseThrow(() -> new ResourceNotFoundException("Invalid User Id"));
	}

	@Override
	public Category fetchCatrgoryDetails(Long category_id) {
	
		return catRepo.findById(category_id).orElseThrow(() -> new ResourceNotFoundException("Invalid User Id"));
	}	


	@Override
	public List<Product> fetcProductDetailsBySubCatrgoryId(SubCategory subCat) {
		
		return prodRepo.findBySubCategory(subCat);
	}

	
	@Override
	public List<Product> fetcProductDetailsByCategoryAndSubCategoryId(Category cat, SubCategory subCat) {
		
		return prodRepo.findByCategoryAndSubCategory(cat, subCat) ;
	}
	

	
	///category_id, image_url, price, product_name, sub_category_id, weight
	@Override
	public ProductRespDto addProduct(ProductDto productDto) {
		
		Category cat= catRepo.getReferenceById(productDto.getCategory_Id());
		
		SubCategory subCat = subCatRepo.getReferenceById(productDto.getSubCategory_Id());
		
		Product product = new Product();
		
		product.setProductname(productDto.getProductname());
		//product.setImageurl(productDto.getImageurl());
		
	String	imageFilePath="C://Users//Admin//Desktop//CCPP//demophoto.jpg " ;
	
	
		File file = new File(imageFilePath);
		if (file.isFile() && file.canRead()) {
			// => valid file
			try {
				product.setImageurl(FileUtils.readFileToByteArray(file));
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}
		product.setPrice(productDto.getPrice());
		product.setWeight(productDto.getWeight());
		product.setCategory(cat);
		product.setSubCategory(subCat);
		
		Product savedProduct = prodRepo.save(product);
//		return mapper.map(savedProduct, ProductRespDto.class);
		ProductRespDto response=new ProductRespDto();
		
		 BeanUtils.copyProperties(savedProduct, response);
		  
		  return  response;
	
	
	}


	
	
}
