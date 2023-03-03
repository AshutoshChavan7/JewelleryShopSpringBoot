package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.UserRepository;
import com.app.dto.RegisterRequest;
import com.app.dto.UserDTO;
import com.app.dto.UserResponseDto;
import com.app.entities.Authentication;
import com.app.entities.Role;

@Service
@Transactional
public class UserServicesImpl implements UserServices {

	@Autowired
	UserRepository repository;
	
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
	
	
//	@Override
//	public boolean updatePass(UserDTO userDto) {
//		if (repository.updatePasswordByEmail(userDto.getEmail(), passEncoder.encode(userDto.getPassword())) == 1)
//			return true;
//		return false;
//	}

}
