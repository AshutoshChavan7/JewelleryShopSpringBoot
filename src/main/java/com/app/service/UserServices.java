package com.app.service;

import com.app.dto.RegisterRequest;
import com.app.dto.UserResponseDto;
import com.app.entities.Authentication;

public interface UserServices {
	Authentication validateUser(String email, String password);
	UserResponseDto RegisterUser(RegisterRequest request);

}
