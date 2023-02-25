package com.app.Service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserRepository;
import com.app.dto.RegisterRequest;
import com.app.dto.UserResponseDto;
import com.app.entities.Authentication;
import com.app.entities.Role;

@Service
@Transactional
public class UserServicesImpl implements UserServices {

	@Autowired
	UserRepository repository;
	
    
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

}
