package com.app.service;

import com.app.dto.RegisterRequest;
import com.app.dto.UserResponseDto;

public interface UserServices {
	
	UserResponseDto RegisterUser(RegisterRequest request);

}
