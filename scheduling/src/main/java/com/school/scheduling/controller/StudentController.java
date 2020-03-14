package com.school.scheduling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.school.scheduling.entity.Student;
import com.school.scheduling.service.Services;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	private Services<Student> studentservice;
	
	@Autowired
	public StudentController(Services<Student> studentservice) {
		this.studentservice = studentservice;
	}
	
	/************************    For the studnet  ******************************/
	
	@GetMapping("/list")
	public String Student_List() {
		return "student/student list/student-list";
	}
	
	@GetMapping("/form")
	public String Student_Form() {
		return "student/student list/student-form";
	}
	
	@PostMapping("/save")
	public String Student_Add() {
		return "redirect:/student/form";
	}
	
	@GetMapping("/delete")
    public String Student_Delete() {
		return "redirect:/student/form";
	}
	
	@GetMapping("/update")
	public String Student_Update() {
		return "redirect:/student/form";
	}
	
	/************************    For the Schedule of student  ******************************/
	@GetMapping("/schedule/list")
	public String StudentSchedule_List() {
		return "student/student schedule/student-schedule";
	}
	
	@GetMapping("/schedule/form")
	public String StudentSchedule_Form() {
		return "student/student schedule/student-schedule-form";
	}
	
	@PostMapping("/schedule/save")
	public String StudentSchedule_Add() {
		return "redirect:/student/schedule/form";
	}
	
	@GetMapping("/schedule/delete")
    public String StudentSchedule_Delete() {
		return "redirect:/student/schedule/form";
	}
	
	@GetMapping("/schedule/update")
	public String StudentSchedule_Update() {
		return "redirect:/student/schedule/form";
		
	}
	
	
	
	
	
}
