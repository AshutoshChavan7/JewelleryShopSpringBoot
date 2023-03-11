package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
public class Category extends BaseEntity {
	
	


	private String categoryName;
	
	
//	@OneToMany(mappedBy = "category" ,cascade= CascadeType.ALL,orphanRemoval = true)
//	
//	private List <SubCategory> subCatList = new ArrayList<SubCategory>();

	public Category() {
		super();
	}

	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
		//this.subCatList = subCatList;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
		
	
	
}
