package com.app.service;

import java.util.List;

import com.app.dto.ProductDto;
import com.app.dto.ProductRespDto;
import com.app.dto.StaffDto;
import com.app.dto.StaffResponseDto;
import com.app.entities.Staff;

public interface StaffSevice {
	
	StaffResponseDto addStaff(StaffDto staff);
	
	List<Staff> getStaff(Long Id);
	
	Staff removeStaff(Long Id);
	
	Staff editStaff(StaffDto Id);

}
