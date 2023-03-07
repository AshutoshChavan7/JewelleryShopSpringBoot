package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.CustomerRepository;
import com.app.dao.ManagerRepository;
import com.app.dao.StaffRepository;
import com.app.dao.UserRepository;
import com.app.dto.RegisterRequest;
import com.app.dto.UserDTO;
import com.app.dto.UserResponseDto;
import com.app.entities.Authentication;
import com.app.entities.Customer;
import com.app.entities.Manager;
import com.app.entities.Role;
import com.app.entities.Staff;
import com.app.entities.SubCategory;

@Service
@Transactional
public class UserServicesImpl implements UserServices {

	@Autowired
	UserRepository repository;
	
	@Autowired
	ManagerRepository manrepo;
	@Autowired
	CustomerRepository cusrepo;
	@Autowired
	StaffRepository staffrepo;
	
//	@Autowired
//	private PasswordEncoder passEncoder;
	
	@Override
	public UserResponseDto RegisterUser(RegisterRequest request) {
		
		Authentication authenticate=new Authentication();
		
		authenticate.setMailId(request.getEmail());
		authenticate.setPassword(request.getPassword());
		authenticate.setRole(request.getRole());
		
		Authentication persistedAuth=repository.save(authenticate);
	
		UserResponseDto response=new UserResponseDto();
		
		BeanUtils.copyProperties(persistedAuth, response);
		
		return response;
		
		
	}


	@Override
	public Authentication validateUser(String username, String password) {
	   
		Authentication auth=repository.findBymailId(username)
				.orElseThrow(()->new ResourceNotFoundException("User Not Found"));
		//System.out.println(auth);
		System.out.println(auth.getPassword().equals(password));
		if(auth.getPassword().equals(password)) {
			return auth;
		}
	   return null;
	}


	@Override
	public Manager fetchManager(Authentication id) {
		// TODO Auto-generated method stub
		System.out.println("inside fetchmanager");
		return manrepo.findManagerByAuthentication(id);
	}


	@Override
	public Staff fetchStaff(Authentication id) {
		// TODO Auto-generated method stub
		//return staffrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Staff not found"));
		System.out.println("inside fetchstaff method"+id);
		return staffrepo.findStaffByAuthentication(id);
	}


	@Override
	public Customer fetchCustomer(Authentication id) {
		// TODO Auto-generated method stub
		return cusrepo.findCustomerByAuthentication(id);
	}


	
	
//	@Override
//	public boolean updatePass(UserDTO userDto) {
//		if (repository.updatePasswordByEmail(userDto.getEmail(), passEncoder.encode(userDto.getPassword())) == 1)
//			return true;
//		return false;
//	}

}
