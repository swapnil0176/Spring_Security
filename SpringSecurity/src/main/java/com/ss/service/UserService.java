package com.ss.service;

import com.ss.entity.User;

public interface UserService {
	public User saveUser(User user);
	public void findByUsername(String username);
}
