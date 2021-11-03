package com.securityprac.springjwtref.util;

import org.springframework.stereotype.Component;

@Component
public class TokenRefreshResponse {

	private String accessToken;
	private String refreshToken;

	public TokenRefreshResponse() {

	}

	public TokenRefreshResponse(String accessToken, String refreshToken) {
		super();
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}
