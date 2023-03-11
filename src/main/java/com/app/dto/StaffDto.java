package com.app.dto;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.app.entities.Address;
import com.app.entities.Authentication;
import com.app.entities.Manager;
import com.app.entities.SubCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



public class StaffDto {
	
	private Long id ;

	private String staffName;

	
	private int contactNo;

	private Long subcategoryId; 

	
	

	private String email;
	private String password;
	
     private String city;
	
	private String state;
	
	private int zip;
	
	private Long manager;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getManager() {
		return manager;
	}

	public void setManager(Long manager) {
		this.manager = manager;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public Long getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(Long subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public StaffDto(String staffName, int contactNo, Long subcategoryId, String email, String password, String city,
			String state, int zip) {
		super();
		this.staffName = staffName;
		this.contactNo = contactNo;
		this.subcategoryId = subcategoryId;
		this.email = email;
		this.password = password;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public StaffDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
