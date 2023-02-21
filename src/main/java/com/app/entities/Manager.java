package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


public class Manager extends BaseEntity {


	
	@Column(length= 20)
	private String managerName;
	
	@Embedded
	private Address address;
	
	@OneToOne
	@JoinColumn(name="categoty_id")
	private Category productCategory;
	
	@OneToOne
	@JoinColumn(name="authentication")
	private Authentication athentication;

	@OneToMany(mappedBy = "manager" ,cascade= CascadeType.ALL,orphanRemoval = true)
	private List <Staff> staffList = new ArrayList<Staff>();

}
