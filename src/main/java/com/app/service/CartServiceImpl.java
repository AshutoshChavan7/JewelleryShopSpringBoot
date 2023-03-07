package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.CartRepository;
import com.app.dao.CustomerRepository;
import com.app.entities.CartItem;
import com.app.entities.Customer;
import com.app.entities.Product;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ProductService prodService;
	
	@Autowired
	private CartRepository cartRepo;
	
	@Override
	public Long addProduct(Long productId, Long customerId, Long quantity) {
		Customer customer = custRepo.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Invalid customer Id"));
		
		//log.info("In Shopping cart service : Add product to cart method");
		Long updatedQuantity = quantity;
		Product product = prodService.fetchProductById(productId);
		//log.info("Product to add in cart" + product);
		
		CartItem cartItem = cartRepo.findByCustomerAndProduct(customer, product);

		if (cartItem != null) {
			updatedQuantity = cartItem.getQuantity() + quantity;
			if (updatedQuantity < 0) {
				System.out.println("Invalid quanity");
			}
			if (updatedQuantity > 5) {
				 System.out.println("Could not add more " + quantity + " item(s)"
						+ " because there's already " + cartItem.getQuantity() + " item(s) "
						+ "in your shopping cart. Maximum allowed quantity is 5.");
			}
		} else {
			cartItem = new CartItem();
			cartItem.setCustomer(customer);
			cartItem.setProduct(product);
		}

		cartItem.setQuantity(updatedQuantity);

		cartRepo.save(cartItem);

		return updatedQuantity;
		
	}
	
	// Add a method to get list of cart Items
	@Override
	public List<CartItem> listCartItems(Long customerId) {
		//log.info("In shopping cart service : list cart items method");
		Customer customer = custRepo.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Invalid customer Id"));
	
			return cartRepo.findByCustomer(customer);
		
	}

	@Override
	public void removeProduct(Long productId, Long customerId) {
		//log.info("In shopping cart service : removeProduct");
		Customer customer = custRepo.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Invalid customer Id"));
		Product product = prodService.fetchProductById(productId);
		cartRepo.deleteByCustomerAndProduct(customer, product);
	}
	
//	@Override
//	public void removeProduct(Long productId, Long customerId) {
//		// TODO Auto-generated method stub
//		
//	}

//	@Override
//	public List<CartItem> listCartItems(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}
