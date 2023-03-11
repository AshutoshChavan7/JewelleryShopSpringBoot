package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@Getter
@Setter


@Entity
public class Staff extends BaseEntity {


@Column(length = 20)
private String staffName;

@Column(length= 10)
private int contactNo;

@Embedded
private Address address;

  @ManyToOne
@JoinColumn(name="manager_id")
@JsonProperty(access = Access.WRITE_ONLY)
private Manager manager;

@OneToOne
@JoinColumn(name="subCategory_id")
@JsonProperty(access=Access.WRITE_ONLY)
private SubCategory productSubCategory; 

@OneToOne
@JoinColumn(name="authentication")
private Authentication athentication;

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

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

public SubCategory getProductSubCategory() {
	return productSubCategory;
}

public void setProductSubCategory(SubCategory productSubCategory) {
	this.productSubCategory = productSubCategory;
}

public Authentication getAthentication() {
	return athentication;
}

public void setAthentication(Authentication athentication) {
	this.athentication = athentication;
}



public Staff() {
	super();
	// TODO Auto-generated constructor stub
}

public Staff(Long id) {
	super(id);
	// TODO Auto-generated constructor stub
}

public Staff(Long id, String staffName, int contactNo, Address address, Manager manager, SubCategory productSubCategory,
		Authentication athentication) {
	super(id);
	this.staffName = staffName;
	this.contactNo = contactNo;
	this.address = address;
	this.manager = manager;
	this.productSubCategory = productSubCategory;
	this.athentication = athentication;
}

public void setManager(Manager manager) {
	this.manager = manager;
}
	


}
