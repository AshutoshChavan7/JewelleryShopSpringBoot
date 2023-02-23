package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
public class Manager {

	@Column(length=50)
	private String email;
	
	@Column(length= 20)
	private String managerName;
	
	@Embedded
	private Address address;
	
	@OneToOne
	@JoinColumn(name="categoty_id")
	private Category productCategory;
	
	
}
