package com.app.entities;

import java.util.ArrayList;
import java.util.List;

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
public class Category extends BaseEntity {
	
	

	public Category(String categoryName, List<SubCategory> subCatList) {
		super();
		this.categoryName = categoryName;
		this.subCatList = subCatList;
	}

	private String categoryName;
	
	@OneToMany(mappedBy = "category" ,cascade= CascadeType.ALL,orphanRemoval = true)
	private List <SubCategory> subCatList = new ArrayList<SubCategory>();

	public Category() {
		super();
	}

	
		
	
	
}
