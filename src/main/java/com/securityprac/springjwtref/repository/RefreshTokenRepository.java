package com.securityprac.springjwtref.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.securityprac.springjwtref.models.RefreshToken;
import com.securityprac.springjwtref.models.User;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long>{

	@Override
	Optional<RefreshToken> findById(Long id);
	
	Optional<RefreshToken> findByToken(String token);
	
	void deleteByUser(User user);
}
