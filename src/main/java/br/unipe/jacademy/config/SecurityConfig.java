package br.unipe.jacademy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("css","/css/*","/css").permitAll()
            .antMatchers("*/sala/*").hasRole("ADMIN")
            
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login").permitAll()
            .and()
        .logout().permitAll()
        .and()
            .exceptionHandling().accessDeniedPage("/403");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser("user").password(encoder.encode("user")).roles("USER")
			.and()
			.withUser("admin").password(encoder.encode("admin")).roles("ADMIN");
		
	}
}