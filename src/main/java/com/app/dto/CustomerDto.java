package com.app.dto;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.app.entities.Address;
import com.app.entities.Authentication;
import com.app.entities.Manager;
import com.app.entities.SubCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



public class CustomerDto {
	

	private String customerName;

	private int cotactNo; 
    
	private String email;
	
	private String password;
	
    private String city;
	
	private String state;
	
	private int zip;

	public CustomerDto(String customerName, int cotactNo, String email, String password, String city, String state,
			int zip) {
		super();
		this.customerName = customerName;
		this.cotactNo = cotactNo;
		this.email = email;
		this.password = password;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CustomerDto [customerName=" + customerName + ", cotactNo=" + cotactNo + ", email=" + email
				+ ", password=" + password + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	
	
	
	

}
