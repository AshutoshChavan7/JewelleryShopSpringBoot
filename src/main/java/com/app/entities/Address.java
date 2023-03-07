package com.app.entities;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Embeddable
public class Address {
	
	private String city;
	
	private String state;
	
	private int zip;

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

	public Address(String city, String state, int zip) {
		super();
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
