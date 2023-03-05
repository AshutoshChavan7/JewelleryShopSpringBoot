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


@NoArgsConstructor
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
     
//	@JsonIgnore
//	@OneToMany(mappedBy = "manager",cascade= CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
//	private List <Staff> staffList=new ArrayList<Staff>();

}
