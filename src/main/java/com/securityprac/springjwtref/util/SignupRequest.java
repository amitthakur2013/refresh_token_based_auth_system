package com.securityprac.springjwtref.util;

import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class SignupRequest {
	
	private String username;
	
	private String password;
	
	private String email;
	
	private Set<String> role;

	public SignupRequest() {
		
	}

	public SignupRequest(String username, String password, String email, Set<String> role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

		

}