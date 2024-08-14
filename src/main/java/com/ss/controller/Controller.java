package com.ss.controller;

import org.springframework.web.bind.annotation.GetMapping;

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
}
