package com.school.scheduling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String LoginController() {
//		"room/RoomBreaktime"
		return "login";
	}
	
	
}
