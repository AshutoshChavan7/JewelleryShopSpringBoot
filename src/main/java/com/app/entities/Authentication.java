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



@ToString
@Entity
public class Authentication extends BaseEntity {
     
	@Column(length=20,nullable = false,unique = true)
	private String mailId;
	@Column(length=20,nullable=false,unique=true)
	private String password;
//	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private String role;
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Authentication(String mailId, String password, String role) {
		super();
		this.mailId = mailId;
		this.password = password;
		this.role = role;
	}
	public Authentication() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
