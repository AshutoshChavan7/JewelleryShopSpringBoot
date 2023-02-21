package com.app.entities;

import javax.persistence.*;

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
public class Order extends BaseEntity {
	
	@Column(name="total_qty")
	private int totalQuantity;
	@Column(name="total_amount",nullable=false)
	private int totalAmount;
	
}
