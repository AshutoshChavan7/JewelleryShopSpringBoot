package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ManagerRepository;
import com.app.dao.ProductRepository;
import com.app.dto.ManagerResponseDto;
import com.app.entities.Category;
import com.app.entities.Manager;
import com.app.entities.Product;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerRepository manrepo;
	@Autowired
	private ProductRepository prodrepo;
	
//	@Override
//	public int getAllProducts(Long managerId) {
//		// TODO Auto-generated method stub
//		
//		Manager manager=manrepo.getById(managerId);
//		Category cat=manager.getProductCategory();
//		List<Product> prodlist=prodrepo.findByCategory(cat);
//		int count=0;
//		
//		for(Product p:prodlist) {
//			
//		
//			if(p.getCategory().getCategoryName().equals("Gold")) {
//				
//				count++;
//			}
//		}
//		
//		return count;
//	}

	@Override
	public ManagerResponseDto getAllProduct(Long managerId) {
		// TODO Auto-generated method stub
		Manager manager=manrepo.getById(managerId);
		Category cat=manager.getProductCategory();
		List<Product> prodlist=prodrepo.findByCategory(cat);
		System.out.println(prodlist.size());
		int arr[]=new int[8];
		for(Product p:prodlist) {
			
		
			if(p.getSubCategory().getSubcategoryName().equals("Ring")) {
				
				  arr[0]=arr[0]+1;
				  continue;
			}
			else if(p.getSubCategory().getSubcategoryName().equals("chain")) {
				
				  arr[1]=arr[1]+1;
				  continue;
			}
			else if(p.getSubCategory().getSubcategoryName().equals("Manalsutra")) {
				
				  arr[2]=arr[2]+1;
				  continue;
			}
			else if(p.getSubCategory().getSubcategoryName().equals("Pendant")) {
				
				  arr[3]=arr[3]+1;
				  continue;
			}
			else if(p.getSubCategory().getSubcategoryName().equals("Bangles")) {
				
				  arr[4]=arr[4]+1;
				  continue;
			}
			else if(p.getSubCategory().getSubcategoryName().equals("Braclet")) {
				
				  arr[5]=arr[5]+1;
				  continue;
			}
			else if(p.getSubCategory().getSubcategoryName().equals("Neacklace")) {
				
				  arr[6]=arr[6]+1;
				  continue;
			}
			else if(p.getSubCategory().getSubcategoryName().equals("Other")) {
				
				  arr[7]=arr[7]+1;
				  continue;
			}
			
		}
		
		ManagerResponseDto resp=new ManagerResponseDto();
		resp.setIntlist(arr);
		resp.setCategoryName(manager.getProductCategory().getCategoryName());
		
		return resp;
	}

}
