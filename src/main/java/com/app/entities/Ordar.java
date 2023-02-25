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
	
	@Column(name="totalqty")
	private int totalQuantity;
	@Column(name="totalamount")
	private double totalAmount;
	
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="product_order",joinColumns= @JoinColumn(name="order_id")
	,inverseJoinColumns = @JoinColumn(name="Prduct_id"))
	private Set<Product> productset= new HashSet<Product>();



	public int getTotalQuantity() {
		return totalQuantity;
	}



	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}



	public double getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}



	public Set<Product> getProductset() {
		return productset;
	}



	public void setProductset(Set<Product> productset) {
		this.productset = productset;
	}



	@Override
	public String toString() {
		return "Order [totalQuantity=" + totalQuantity + ", totalAmount=" + totalAmount + ", productset=" + productset
				+ "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(productset);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordar other = (Ordar) obj;
		return Objects.equals(productset, other.productset);
	}



	public Ordar(int totalQuantity, double totalAmount, Set<Product> productset) {
		super();
		this.totalQuantity = totalQuantity;
		this.totalAmount = totalAmount;
		this.productset = productset;
	}



	public Ordar() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Ordar(Integer id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
