package com.securityprac.springjwtref.util;

import org.springframework.stereotype.Component;

@Component
public class TokenRefreshRequest {

	private String refreshToken;

	public TokenRefreshRequest() {

	}

	public TokenRefreshRequest(String refreshToken) {
		super();
		this.refreshToken = refreshToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}
