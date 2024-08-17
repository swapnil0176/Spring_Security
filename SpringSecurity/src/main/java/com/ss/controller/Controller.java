package com.ss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping("/user/home")
	public String viewUser() {
		return "user";
	}
	
	@GetMapping("/admin/home")
	public String viewAdmin() {
		return "admin";
	}
	
	@GetMapping("/home")
	public String viewHome() {
		return "home";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		
		return "custom_login";
	}
}
