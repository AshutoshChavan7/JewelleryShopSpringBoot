package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderByCartDto {
	
	private String productName;
	
	private Long quantity;
	
	private double price;

	private String customername;
	
	private Long orderid;
	
	private Double totalAmountl;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public Double getTotalAmountl() {
		return totalAmountl;
	}

	public void setTotalAmountl(Double totalAmountl) {
		this.totalAmountl = totalAmountl;
	}

	public OrderByCartDto(String productName, Long quantity, double price, String customername, Long orderid,
			Double totalAmountl) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.customername = customername;
		this.orderid = orderid;
		this.totalAmountl = totalAmountl;
	}

	public OrderByCartDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

}
