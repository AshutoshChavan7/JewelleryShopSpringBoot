package com.app.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddCartDto {
	private Long productId;
	private Long customerId;
	private Long quantity;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public AddCartDto(Long productId, Long customerId, Long quantity) {
		super();
		this.productId = productId;
		this.customerId = customerId;
		this.quantity = quantity;
	}
	public AddCartDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
