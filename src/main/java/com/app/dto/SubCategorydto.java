package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
//@Getter
//@Setter
public class SubCategorydto {
	
	private String subcategory_name;
	private String category_name;
	
	public String getCategory() {
		return category_name;
	}
	public void setCategory(String category) {
		category_name = category;
	}
	public void setSubcategoryName(String subcategoryName) {
		this.subcategory_name = subcategoryName;
	}
	
	public String getSubcategoryName() {
		// TODO Auto-generated method stub
		return this.subcategory_name;
	}
	
	
	

}
