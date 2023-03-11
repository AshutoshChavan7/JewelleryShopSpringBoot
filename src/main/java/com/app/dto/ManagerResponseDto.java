package com.app.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ManagerResponseDto {
	
	private int [] intlist;
	private String CategoryName;
	public int[] getIntlist() {
		return intlist;
	}
	public void setIntlist(int[] intlist) {
		this.intlist = intlist;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public ManagerResponseDto(int[] intlist, String categoryName) {
		super();
		this.intlist = intlist;
		CategoryName = categoryName;
	}
	public ManagerResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
