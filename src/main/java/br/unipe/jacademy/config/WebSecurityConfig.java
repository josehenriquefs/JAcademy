package br.unipe.jacademy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
            	.antMatchers("/", "/home").permitAll()
            	.antMatchers("/sala/*").hasRole("ADMIN")
            	.antMatchers("/turma/*").hasRole("ADMIN")
            	.antMatchers("css","/css/*","/css").permitAll()
				.anyRequest()
				.authenticated()
			.and()
			.formLogin()
				.loginPage("/login")
				.permitAll();
	}
}
