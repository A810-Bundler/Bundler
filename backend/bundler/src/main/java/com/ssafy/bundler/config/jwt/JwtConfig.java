package com.ssafy.bundler.config.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssafy.bundler.config.auth.AuthTokenProvider;

@Configuration
public class JwtConfig {

	@Value("${jwt.secret}")
	private String secret;

	@Bean
	public AuthTokenProvider jwtProvider() {
		return new AuthTokenProvider(secret);
	}

}
