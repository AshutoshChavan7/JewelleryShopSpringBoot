package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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


@Entity
public class Staff {

@Column(length = 50)
private String email;

@Column(length = 20)
private String staffName;

@Column(length= 10)
private int contactNo;

@Embedded
private Address address;

@ManyToOne
@JoinColumn(name="manager_id")
private Manager manager;

@OneToOne
@JoinColumn(name="subCategory_id")
private SubCategory productSubCategory; 

	
}
