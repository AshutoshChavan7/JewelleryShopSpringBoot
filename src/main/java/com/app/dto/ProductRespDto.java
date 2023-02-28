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
public class ProductRespDto {


	//category_id, image_url, price, product_name, sub_category_id, weight
	private Long id;
	
	private String productname;

	private Long subCategory;

	private Long category;
	
	private double price;

	private double weight;
	
	private String imageurl;

	
	
	
	


	







	public Long getId() {
		return id;
	}







	public void setId(Long id) {
		this.id = id;
	}







	public ProductRespDto(Long id, String productname, Long subCategory, Long category, double price, double weight,
			String imageurl) {
		super();
		this.id = id;
		this.productname = productname;
		this.subCategory = subCategory;
		this.category = category;
		this.price = price;
		this.weight = weight;
		this.imageurl = imageurl;
	}







	public String getProductname() {
		return productname;
	}







	public void setProductname(String productname) {
		this.productname = productname;
	}







	public Long getSubCategory() {
		return subCategory;
	}







	public void setSubCategory(Long subCategory) {
		this.subCategory = subCategory;
	}







	public Long getCategory() {
		return category;
	}







	public void setCategory(Long category) {
		this.category = category;
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







	public ProductRespDto() {
		
	}

	
	
	
	



	
}
