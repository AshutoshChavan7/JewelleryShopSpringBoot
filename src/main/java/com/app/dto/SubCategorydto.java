package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@ToString
@Getter
@Setter
public class SubCategorydto {
	
	private String subcategoryName;
	private String Category;
	public String getSubcategoryName() {
		// TODO Auto-generated method stub
		return this.subcategoryName;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}
	public SubCategorydto(String subcategoryName, String category) {
		super();
		this.subcategoryName = subcategoryName;
		Category = category;
	}

}
