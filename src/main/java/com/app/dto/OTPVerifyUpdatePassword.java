package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OTPVerifyUpdatePassword {
	private String destEmail;
	private int otp;
	private String newPass;
	public String getDestEmail() {
		return destEmail;
	}
	public void setDestEmail(String destEmail) {
		this.destEmail = destEmail;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	public String getNewPass() {
		return newPass;
	}
	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	public OTPVerifyUpdatePassword(String destEmail, int otp, String newPass) {
		super();
		this.destEmail = destEmail;
		this.otp = otp;
		this.newPass = newPass;
	}
	public OTPVerifyUpdatePassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
