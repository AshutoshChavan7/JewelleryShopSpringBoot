package com.app.dto;

import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.app.entities.SubCategory;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.validation.constraints.NotEmpty;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDto {


	//category_id, image_url, price, product_name, sub_category_id, weight
	
	private String productname;

	private Long subCategory_Id;

	private Long category_Id;
	
	private double price;

	private double weight;
	
	private String imageurl;

	
	
	
	


	public ProductDto(String productname, Long subCategory, Long category, double price, double weight,
			String imageurl) {
		super();
		this.productname = productname;
		this.subCategory_Id = subCategory;
		this.category_Id = category;
		this.price = price;
		this.weight = weight;
		this.imageurl = imageurl;
	}


	public ProductDto() {
		
	}
	
	


	public Long getSubCategory_Id() {
		return subCategory_Id;
	}


	public void setSubCategory_Id(Long subCategory_Id) {
		this.subCategory_Id = subCategory_Id;
	}


	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	}


	


	public Long getCategory_Id() {
		return category_Id;
	}


	public void setCategory_Id(Long category_Id) {
		this.category_Id = category_Id;
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


	public String getImageurl() {
		return imageurl;
	}


	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	
	

	
	
	
	



	
}
