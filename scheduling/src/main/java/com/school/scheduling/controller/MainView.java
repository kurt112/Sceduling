package com.school.scheduling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/scheduling")
public class MainView {

	@RequestMapping("/home")
	public String main_view() {
		return "MainView/main-view";
	}
}
