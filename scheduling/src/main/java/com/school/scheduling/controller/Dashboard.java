package com.school.scheduling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Dashboard {
	
	@RequestMapping("/login")
	public String Login(Model model) {
		System.out.println("did i call");
		return "login";
	}
	
	@GetMapping("/dashboard")
	public String dashBoard() {
		System.out.println("im in");
		return "dashboard/dashboard";
	}
	
	@GetMapping("/access-denied")
	public String AccessDeneid() {
		return "access-denied";
	}
	

	
}
