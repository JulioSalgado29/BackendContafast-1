package com.backend.spring.app.security;

public class VerificationToken {
	
	private String token;
	private String email;
	private String password;
	
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public VerificationToken(String token, String email, String password) {
		this.token = token;
		this.email = email;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public VerificationToken() {
		
	}
}
