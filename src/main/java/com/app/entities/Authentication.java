package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Authentication extends BaseEntity {
     
	@Column(length=20,nullable = false,unique = true)
	private String mailId;
	@Column(length=20,nullable=false,unique=true)
	private String password;
//	@Enumerated(EnumType.STRING)
	private String role;
}
