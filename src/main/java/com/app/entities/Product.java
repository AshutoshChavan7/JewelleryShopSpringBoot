package com.app.entities;

import java.sql.Blob;

import javax.persistence.*;
import javax.persistence.ManyToOne;

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
	
	private String productName;
	@Lob //=> col type : longblob for Mysql
	private byte[] image;
	private double price;
	@ManyToOne
	private SubCategory category;
	@ManyToMany
	private Order order;
	
	

}
