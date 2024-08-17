package com.ss.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ss.entity.User;
import com.ss.repository.UserRepository;
import com.ss.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	UserRepository repository;
	
	@Override
	public User saveUser(User user) {

		user.setPassword(encoder.encode(user.getPassword()));
		return repository.save(user);
		
	}

	@Override
	public void findByUsername(String username) {
		// TODO Auto-generated method stub
		
	}
	
}
