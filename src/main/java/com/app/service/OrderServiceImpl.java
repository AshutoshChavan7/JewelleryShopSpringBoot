package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.CartRepository;
import com.app.dao.CustomerRepository;
import com.app.dao.OrderRepository;
import com.app.dto.OrderByCartDto;
import com.app.entities.CartItem;
import com.app.entities.Customer;
import com.app.entities.Ordar;





@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	CustomerRepository custRepo;
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	OrderRepository orderRepo;

	
	
	@Override
	public List<OrderByCartDto> createOrderByUserCart(Long custId) {
		
	Customer customer=	custRepo.findById(custId).orElseThrow(() -> new ResourceNotFoundException("Invalid User Id"));
		
	  List<CartItem> cartitems= cartRepo.findByCustomer(customer);
	  
	  
		
	  //public OrderByCartDto(String productName, Long quantity, double price, String customername, Long orderid) {
	  List<OrderByCartDto> ordList = new ArrayList<OrderByCartDto>();
	  double totalAmount=0;
	  
	  for( int i=0; i<cartitems.size(); i++) {
		
		  
		totalAmount= totalAmount + ((cartitems.get(i).getProduct().getPrice()) * (cartitems.get(i).getQuantity()));
		
	  }
	  
	  Ordar order = new  Ordar();
	  order.setCustomer(customer);
	  order.setTotalAmount(totalAmount);
	  
	   Ordar od=  orderRepo.save(order);
	   
	   customer.setOrder(od);
	   custRepo.save(customer);
	  
	  Long totalQuantity = (long) 0;
	  for( int i=0; i<cartitems.size(); i++) {
		  OrderByCartDto ordDto1 =new OrderByCartDto( (cartitems.get(i).getProduct().getProductname()),
				                                      (cartitems.get(i).getQuantity()),
			                                          (cartitems.get(i).getProduct().getPrice()),
			                                          (cartitems.get(i).getCustomer().getCustomerName()),
			                                          (cartitems.get(i).getCustomer().getOrder().getId()),
			                                          (cartitems.get(i).getCustomer().getOrder().getTotalAmount()));
		  
		//totalAmount= totalAmount + ((cartitems.get(i).getProduct().getPrice()) * (cartitems.get(i).getQuantity()));
		totalQuantity =totalQuantity + ((cartitems.get(i).getQuantity()));
		ordList.add(ordDto1);
	  }
	  
	
	   
	  
	  
		return ordList;
	}

}
