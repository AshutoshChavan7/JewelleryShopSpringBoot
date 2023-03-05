package com.app.service;

import java.util.Optional;

import com.app.dto.RegisterRequest;
import com.app.dto.UserDTO;
import com.app.dto.UserResponseDto;
import com.app.entities.Authentication;
import com.app.entities.Customer;
import com.app.entities.Manager;
import com.app.entities.Staff;

public interface UserServices {
	
	UserResponseDto RegisterUser(RegisterRequest request);

	Authentication validateUser(String username,String password);
	
	Manager fetchManager(Authentication id);
	Staff fetchStaff(Authentication id);
	Customer fetchCustomer(Authentication id);
}
