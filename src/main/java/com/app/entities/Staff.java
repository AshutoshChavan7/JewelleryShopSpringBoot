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

@NoArgsConstructor
@AllArgsConstructor
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

//@ManyToOne
//@JoinColumn(name="manager_id")
//@JsonProperty(access = Access.WRITE_ONLY)
//private Manager manager;

@OneToOne
@JoinColumn(name="subCategory_id")
@JsonProperty(access=Access.WRITE_ONLY)
private SubCategory productSubCategory; 

@OneToOne
@JoinColumn(name="authentication")
private Authentication athentication;
	

}
