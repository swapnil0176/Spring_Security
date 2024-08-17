package com.ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ss.entity.User;
import com.ss.serviceimpl.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	UserServiceImpl service;
	
	@PostMapping("/register/createUser")
	public User createUser(@RequestBody User user){
		return service.saveUser(user);
	}
}
