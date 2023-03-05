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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StaffDto {
	

	private String staffName;

	
	private int contactNo;

	private Long subcategoryId; 

	
	private String email;
	private String password;
	
     private String city;
	
	private String state;
	
	private int zip;

}
