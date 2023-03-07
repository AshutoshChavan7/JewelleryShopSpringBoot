package com.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
//import org.apache.commons.io.FileUtils;
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
	@Value("${file.upload.location}")
	private String folderLocation;

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

	
	public Product fetchProductById(Long prod_id) {
		return prodRepo.findById(prod_id).orElseThrow(() -> new ResourceNotFoundException("Invalid User Id"));
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
		 List<Product> prodlist = prodRepo.findByCategoryAndSubCategory(cat, subCat) ;
	for ( int i=0; i< prodlist.size(); i++) {
		
	String path  =	prodlist.get(i).getPath();
		try {
			prodlist.get(i).setImage(Files.readAllBytes(Paths.get(path)));
		} catch (IOException e) {
			
			e.printStackTrace();
		}    
			
		}
		
		return prodlist;
	}
	

	@Override
	public ProductRespDto addProduct(ProductDto productDto) {
		
		Category cat= catRepo.getReferenceById(productDto.getCategory_Id());
		
		SubCategory subCat = subCatRepo.getReferenceById(productDto.getSubCategory_Id());
		
		Product product = new Product();
		
		product.setProductname(productDto.getProductname());
		//product.setImageurl(productDto.getImageurl());
		
//	String	imageFilePath="C://Users//Admin//Desktop//CCPP//demophoto.jpg " ;
	
		String	imageFilePaths = productDto.getImageurl();
		File file = new File(imageFilePaths);
//		if (file.isFile() && file.canRead()) {
//			// => valid file
//			try {
//				product.setImage(FileUtils.readFileToByteArray(file));
//			} catch (IOException e) {
//			
//				e.printStackTrace();
//			}
//		}
		product.setId(productDto.getId());
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

	@Override
	public byte[] restoreImage(Long productId) throws IOException {
		// TODO Auto-generated method stub
		Product product = prodRepo.findById(productId).orElseThrow(() -> new RuntimeException("No User Found With This ID"));
		String path = product.getPath();
		System.out.println("Path: " + path);
		// java.nio.file.Files : public byte[] readAllBytes(Path path) throws IOExc
		if (path != null)
			return Files.readAllBytes(Paths.get(path));

		// => image is not yet assigned --throw exc to alert front end
		throw new RuntimeException("Image not  yet assigned , for user " + product.getProductname());
	}
	
	@Override
	public String saveImage(Long productId, MultipartFile imgFile) throws IOException {
		//log.info(folderLocation + " " + userId);
		Product product = prodRepo.findById(productId).orElseThrow();
		//log.info(user.toString());
		String path = folderLocation + File.separator + "product" + productId + imgFile.getOriginalFilename();
		//log.info("path " + path);
		product.setPath(path);// update query upon commit
		// Copy uploaded multipart file to server side folder
		// java.nio.file.Files : copy(InputStream in , Path dest, CopyOptions.. ops)
		// Paths.get(String path) ---> Path
		prodRepo.save(product);
		Files.copy(imgFile.getInputStream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);

		return "file saved successfully";
	}

//	@Override
//	public String saveImage(int userId, MultipartFile imgFile) throws IOException {
//		// TODO Auto-generated method stub
//		return null;
//	}


	
	
}
