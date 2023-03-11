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

@Getter
@Setter

@AllArgsConstructor
@ToString

@Entity
public class Customer extends BaseEntity{

@Column( length = 20)
private String customerName;

@Column(length=15)
private int cotactNo;

@Embedded
private Address address;

@OneToOne
//@JoinColumn(name="authentication")
private Authentication athentication;

public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public int getCotactNo() {
	return cotactNo;
}

public void setCotactNo(int cotactNo) {
	this.cotactNo = cotactNo;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

public Authentication getAthentication() {
	return athentication;
}

public void setAthentication(Authentication athentication) {
	this.athentication = athentication;
}

public Customer(Long id, String customerName, int cotactNo, Address address, Authentication athentication) {
	super(id);
	this.customerName = customerName;
	this.cotactNo = cotactNo;
	this.address = address;
	this.athentication = athentication;
}

public Customer() {
	super();
	// TODO Auto-generated constructor stub
}

public Customer(Long id) {
	super(id);
	// TODO Auto-generated constructor stub
}

@OneToOne
//@JoinColumn(name="order")
private Ordar order;

public Ordar getOrder() {
	return order;
}

public void setOrder(Ordar order) {
	this.order = order;
}




	
}
