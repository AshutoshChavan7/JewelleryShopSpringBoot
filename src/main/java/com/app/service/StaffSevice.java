package com.app.service;

import com.app.dto.ProductDto;
import com.app.dto.ProductRespDto;
import com.app.dto.StaffDto;
import com.app.dto.StaffResponseDto;
import com.app.entities.Staff;

public interface StaffSevice {
	
	StaffResponseDto addStaff(StaffDto staff);

}
