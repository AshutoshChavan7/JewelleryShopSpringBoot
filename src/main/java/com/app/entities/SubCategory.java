package com.app.entities;

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

public class SubCategory extends BaseEntity {

	private String subcategoryName;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Category category;
	public String getSubcategoryName() {
		return subcategoryName;
	}
	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public SubCategory(String subcategoryName, Category category) {
		super();
		this.subcategoryName = subcategoryName;
		this.category = category;
	}
	public SubCategory() {
		super();
	}
	
	
	
}
