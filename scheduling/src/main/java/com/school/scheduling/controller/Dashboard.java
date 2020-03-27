package com.school.scheduling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Dashboard {
	
	@GetMapping("dashboard")
	public String dashBoard() {
		System.out.println("im in");
		return "dashboard/dashboard";
	}
}
