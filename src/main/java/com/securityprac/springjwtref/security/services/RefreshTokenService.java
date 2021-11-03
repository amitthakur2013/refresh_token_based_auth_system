package com.securityprac.springjwtref.security.services;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.securityprac.springjwtref.models.RefreshToken;
import com.securityprac.springjwtref.repository.RefreshTokenRepository;
import com.securityprac.springjwtref.repository.UserRepository;
import com.securityprac.springjwtref.security.jwt.TokenRefreshException;

@Service
public class RefreshTokenService {

	@Value("${bezkoder.app.jwtRefreshExpirationMs}")
	private Long refreshTokenDurationMs;
	
	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Optional<RefreshToken> findByToken(String token) {
		return refreshTokenRepository.findByToken(token);
	}
	
	public RefreshToken createRefreshToken(Long userId) {
		RefreshToken refreshToken = new RefreshToken();
		
		refreshToken.setUser(userRepository.findById(userId).get());
		refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
		refreshToken.setToken(UUID.randomUUID().toString());
		
		refreshToken = refreshTokenRepository.save(refreshToken);
		return refreshToken;
		
	}
	
	public RefreshToken verifyExpiration(RefreshToken token) {
		if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
			refreshTokenRepository.delete(token);
			throw new TokenRefreshException(token.getToken(),"Refresh token was expired. Please make a new signin request");
		}
		
		return token;
	}
	
	@Transactional
	public void deletByUserId(Long userId) {
		refreshTokenRepository.deleteByUser(userRepository.findById(userId).get());
	}
	
}
