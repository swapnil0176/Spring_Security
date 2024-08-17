package com.ss.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilter {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception{
		return security
				.csrf(csrf->csrf.disable())
				.authorizeHttpRequests(auth->auth
						.requestMatchers("/home","/register/**").permitAll()
						.requestMatchers("/admin/**").hasRole("ADMIN")
						.requestMatchers("/user/**").hasRole("USER").anyRequest()
						.authenticated())
				.formLogin(form->form
						.loginPage("/login")
						.permitAll())
				.build();
	}
}
