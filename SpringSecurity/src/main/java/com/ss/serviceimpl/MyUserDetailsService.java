package com.ss.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ss.entity.User;
import com.ss.repository.UserRepository;

@Configuration
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Enter user name is "+username);
		Optional<User> user=repository.findByUsername(username);
		if(user.isPresent()) {
			var userObject=user.get();
			return org.springframework.security.core.userdetails.User.builder()
			.username(userObject.getUsername())
			.password(userObject.getPassword())
			.roles(userObject.getRole())
			.build();
		}
		else {
			throw new UsernameNotFoundException(username);
		}
		
	}

}
