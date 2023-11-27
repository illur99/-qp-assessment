package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class Securityonfiguration {
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetails()
	{
		UserDetails normalUser= User.withUsername("Arpita")
				.password(passwordEncoder().encode("Pwd")).roles("USER")
				.build();
		
		UserDetails adminUser= User.withUsername("Alok")
				.password(passwordEncoder().encode("Pwd1")).roles("ADMIN")
				.build();
		
		
		return new InMemoryUserDetailsManager(normalUser,adminUser);
		
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception
	{
		security.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/test")
		.authenticated()
		.and()
//		.authorizeHttpRequests()
//		.requestMatchers("/getAll")
//		.authenticated()
		.authorizeHttpRequests()
		.anyRequest()
		.permitAll()
		.and()
		.formLogin();
		
		return security.build();
		
		
	}

}
