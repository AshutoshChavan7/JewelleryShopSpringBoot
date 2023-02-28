package com.app.entities;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Product extends BaseEntity{
	
	////category_id, image_url, price, product_name, sub_category_id, weight
	private String productname;
	@Lob //=> col type : longblob for Mysql
	private byte[] image;
	private double price;
	
	private double weight;


//	@ManyToOne
//	@JoinColumn(name = "user_Id")
//	private User user;
	
	@ManyToOne
	@JoinColumn(name = "subCategory")
	private SubCategory subCategory;
	
	@ManyToOne
	@JoinColumn(name = "category_Id")
	private Category category;


	
	
	public Product(String productname, byte[] imageurl, double price, double weight, SubCategory subCategory,
			Category category) {
		super();
		this.productname = productname;
		this.image = imageurl;
		this.price = price;
		this.weight = weight;
		this.subCategory = subCategory;
		this.category = category;
	}




	public String getProductname() {
		return productname;
	}




	public void setProductname(String productname) {
		this.productname = productname;
	}




	public byte[] getImage() {
		return image;
	}




	public void setImageurl(byte[] bs) {
		this.image = bs;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public double getWeight() {
		return weight;
	}




	public void setWeight(double weight) {
		this.weight = weight;
	}




	public SubCategory getSubCategory() {
		return subCategory;
	}




	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}




	public Category getCategory() {
		return category;
	}




	public void setCategory(Category category) {
		this.category = category;
	}




	public Product() {
		
	}

	
	
	

}
