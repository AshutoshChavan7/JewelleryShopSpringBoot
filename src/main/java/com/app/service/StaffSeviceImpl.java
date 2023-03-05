package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CategoryRepository;
import com.app.dao.ManagerRepository;
import com.app.dao.StaffRepository;
import com.app.dao.SubCategoryRepository;
import com.app.dto.StaffDto;
import com.app.dto.StaffResponseDto;
import com.app.entities.Address;
import com.app.entities.Authentication;
import com.app.entities.Category;
import com.app.entities.Manager;
import com.app.entities.Staff;
import com.app.entities.SubCategory;

@Service
@Transactional
public class StaffSeviceImpl implements StaffSevice {

	@Autowired
	SubCategoryRepository subcatrepo;
	@Autowired
	ManagerRepository manrepo;
	@Autowired
	AuthenticationRepository authrepo;
	@Autowired
	StaffRepository staffrepo;
	
	@Override
	public StaffResponseDto addStaff(StaffDto staff) {
		// TODO Auto-generated method stub
		SubCategory cat= subcatrepo.getById(staff.getSubcategoryId());
		//Manager mgr=manrepo.getById(staff.getManagerId());
		
		//authentication entity generation
		Authentication auth=new Authentication();
		auth.setMailId(staff.getEmail());
		auth.setPassword(staff.getPassword());
		auth.setRole("Staff");
		Authentication authenticaterepsonse=authrepo.save(auth);
		
		//adress object generation from dto
		Address ads=new Address();
		ads.setCity(staff.getCity());
		ads.setState(staff.getState());
		ads.setZip(staff.getZip());
		
		Staff stf=new Staff();
	//	stf.setManager(mgr);
		stf.setProductSubCategory(cat);
		stf.setStaffName(staff.getStaffName());
		stf.setAthentication(authenticaterepsonse);
		stf.setContactNo(staff.getContactNo());
		stf.setAddress(ads);
		
		Staff sdto=staffrepo.save(stf);
		
		return null;
	}

}
