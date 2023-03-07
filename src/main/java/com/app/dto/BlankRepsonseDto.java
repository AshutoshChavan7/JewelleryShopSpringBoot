package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class BlankRepsonseDto {
	
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public BlankRepsonseDto(String msg) {
		super();
		this.msg = msg;
	}

	public BlankRepsonseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
