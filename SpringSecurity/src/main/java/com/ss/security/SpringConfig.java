package com.ss.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.ss.serviceimpl.MyUserDetailsService;

@Configuration
public class SpringConfig { 
	
	@Autowired
	MyUserDetailsService userService;
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
		provider.setUserDetailsService(userService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return userService;
		//the commented code is for save the user details in memory
//		UserDetails admin=User.builder()
//				.username("Swapnil")
//				.password(passwordEncoder().encode("1234"))
//				.roles("ADMIN")
//				.build();
//		UserDetails user = User.builder()
//				.username("Sam")
//				.password(passwordEncoder().encode("1234"))
//				.roles("USER")
//				.build();
//		return new InMemoryUserDetailsManager(admin,user);
	}
	
	

}
