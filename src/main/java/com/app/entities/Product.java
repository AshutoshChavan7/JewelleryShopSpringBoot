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
@ToString
@Getter
@Setter
public class Product {
	
	////category_id, image_url, price, product_name, sub_category_id, weight
	@Id
	private Long id;
	private String productname;
	@Lob //=> col type : longblob for Mysql
	private byte[] image;
	private double price;
	
	private double weight;
    
	private String path;

//	@ManyToOne
//	@JoinColumn(name = "user_Id")
//	private User user;
	
	@ManyToOne
	@JoinColumn(name = "subCategory")
	private SubCategory subCategory;
	
	@ManyToOne
	@JoinColumn(name = "category_Id")
	private Category category;


	
	

	public Product(Long id, String productname, byte[] image, double price, double weight, String path,
			SubCategory subCategory, Category category) {
		super();
		this.id = id;
		this.productname = productname;
		this.image = image;
		this.price = price;
		this.weight = weight;
		this.path = path;
		this.subCategory = subCategory;
		this.category = category;
	}













	public Long getId() {
		return id;
	}













	public void setId(Long id) {
		this.id = id;
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













	public void setImage(byte[] image) {
		this.image = image;
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













	public String getPath() {
		return path;
	}













	public void setPath(String path) {
		this.path = path;
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
