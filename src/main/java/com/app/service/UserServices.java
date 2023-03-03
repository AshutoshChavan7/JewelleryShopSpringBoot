package com.app.service;

import java.util.Optional;

import com.app.dto.RegisterRequest;
import com.app.dto.UserDTO;
import com.app.dto.UserResponseDto;
import com.app.entities.Authentication;

public interface UserServices {
	
	UserResponseDto RegisterUser(RegisterRequest request);

	Authentication validateUser(String username,String password);
	
	
}
