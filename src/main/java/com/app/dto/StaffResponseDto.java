package com.app.dto;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.app.entities.Address;
import com.app.entities.Authentication;
import com.app.entities.BaseEntity;
import com.app.entities.Manager;
import com.app.entities.SubCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter



public class StaffResponseDto extends BaseEntity {



private String staffName;


private int contactNo;

@Embedded
private Address address;


private Manager manager;


private SubCategory productSubCategory; 


private Authentication athentication;
	

}
