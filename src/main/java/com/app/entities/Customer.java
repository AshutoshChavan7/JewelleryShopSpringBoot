package com.app.entities;

import javax.persistence.Column;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Customer extends BaseEntity{

@Column(length = 50)
private String email;

@Column( length = 20)
private String customerName;

@Column(length=15)
private int cotactNo;

@Embedded
private Address address;

@Column
@OneToOne
private Order order;



	
}
