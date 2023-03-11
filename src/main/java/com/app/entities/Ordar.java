package com.app.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
public class Ordar extends BaseEntity {
	
	@OneToOne
	private Customer customer;
	@Column(name="totalamount")
	private double totalAmount;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Ordar(Long id, Customer customer, double totalAmount) {
		super(id);
		this.customer = customer;
		this.totalAmount = totalAmount;
	}
	public Ordar() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ordar(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name="product_order",joinColumns= @JoinColumn(name="order_id")
//	,inverseJoinColumns = @JoinColumn(name="Prduct_id"))
//	private Set<Product> productset= new HashSet<Product>();



	
	
	
}
