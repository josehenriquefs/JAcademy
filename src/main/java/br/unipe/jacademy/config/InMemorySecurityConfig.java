package br.unipe.jacademy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class InMemorySecurityConfig {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		String userName = "user";
		String userRole = "USER";
		String adminName = "admin";
		String adminRole = "ADMIN";
		
		auth
			.inMemoryAuthentication().withUser(userName).password(encoder.encode(userName)).roles(userRole)
			.and()
			.withUser(adminName).password(encoder.encode(adminName)).roles(userRole,adminRole);
		
	}
}
