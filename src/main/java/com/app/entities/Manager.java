package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Manager extends BaseEntity {


	
	@Column(length= 20)
	private String managerName;
	
	@Embedded
	private Address address;
	
	@OneToOne
	@JoinColumn(name="categoty_id")
	private Category productCategory;
	
	@OneToOne
	private Authentication athentication;

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}

	public Authentication getAthentication() {
		return athentication;
	}

	public void setAthentication(Authentication athentication) {
		this.athentication = athentication;
	}

	public Manager(Long id, String managerName, Address address, Category productCategory,
			Authentication athentication) {
		super(id);
		this.managerName = managerName;
		this.address = address;
		this.productCategory = productCategory;
		this.athentication = athentication;
	}

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
     
//	@JsonIgnore
//	@OneToMany(mappedBy = "manager",cascade= CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
//	private List <Staff> staffList=new ArrayList<Staff>();

	
	
}
