package com.juliechan.loginreg.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class LoginUser { // FOR USER LOGIN
	@Email(message = "Please enter a valid email! Email is a required field.")
	private String email;
	
	@Size(min = 8, max = 128, message = "must be at least 8 characters long.")
	private String pw;
	
	public LoginUser() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
}