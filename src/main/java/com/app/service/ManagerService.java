package com.app.service;

import java.util.List;

import com.app.dto.ManagerResponseDto;
import com.app.entities.Product;

public interface ManagerService {
	
	public ManagerResponseDto getAllProduct(Long managerId);

}
