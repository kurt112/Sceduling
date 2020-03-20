package com.school.scheduling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.school.scheduling.entity.Subject;
import com.school.scheduling.entity.Teacher;
import com.school.scheduling.entity.Teacher_Schedule;
import com.school.scheduling.service.Services;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	private Services<Teacher> teacherService;
	private Services<Teacher_Schedule> teacherSchedule;
	
	@Autowired
	public TeacherController(Services<Teacher> teacherService,
			Services<Teacher_Schedule> teacherSchedule) {
		this.teacherService = teacherService;
		this.teacherSchedule = teacherSchedule;
	}
	
	/**********************    ForTeacher     ******************************/
	@GetMapping("/list")
	public String Teacher_List() {
		return "teacher/teacher information/teacher-information";
	}
	
	@GetMapping("/form")
	public String Teacher_Form() {
		return "teacher/teacher information/teacher-information-form";
	}
	@PostMapping("/save")
	public String Teacher_Save() {
		return "redirect:/teacher/form";
	}
	@GetMapping("/update")
	public String Teacher_Update() {
		return "redirect:/teacher/form";
	}
	@GetMapping("/delete")
	public String Teacher_Delete() {
		return "redirect:/teacher/form";
	}
	
	/**********************    ForTeacherBreak     ******************************/
	
	@GetMapping("/break/list")
	public String TeacherBreak_List() {
		System.out.println("im in break");
		return "teacher/teacher breaktime/teacher-breaktime";
	}
	
	@GetMapping("/break/form")
	public String TeacherBreak_Form() {
		return "teacher/teacher breaktime/teacher-breaktime-form";
	}
	@PostMapping("/break/save")
	public String TeacherBreak_Save() {
		return "redirect:/teacher/break/form";
	}
	@GetMapping("/break/update")
	public String TeacherBreak_Update() {
		return "redirect:/teacher/break/form";
	}
	@GetMapping("/break/delete")
	public String TeacherBreak_Delete() {
		return "redirect:/teacher/break/form";
	}
	
	/************************** For teacher schedule ************************/
	
	@GetMapping("/schedule/list")
	public String TeacherSchedule_List() {
		return "teacher/teacher schedule/teacher-schedule";
	}
	
	@GetMapping("/schedule/form")
	public String TeacherSchedule_Form() {
		return "teacher/teacher schedule/teacher-schedule-form";
	}
	
	@PostMapping("/schedule/save")
	public String TeacherSchedule_Save() {
		return "redirect:/teacher/schedule/form";
	}
	
	@GetMapping("/schedule/update")
	public String TeacherSchedule_Update() {
		return "redirect:/teacher/schedule/form";
	}
	
	@GetMapping("/schedule/delete")
	public String TeacherSchedule_Delete() {
		return "redirect:/teacher/schedule/form";
	}
}
