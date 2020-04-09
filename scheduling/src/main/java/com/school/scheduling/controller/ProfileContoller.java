package com.school.scheduling.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.scheduling.entity.Room_Shift;
import com.school.scheduling.entity.StrandAndCourse;
import com.school.scheduling.entity.Student;
import com.school.scheduling.entity.Teacher;
import com.school.scheduling.service.Services;

@Controller
@RequestMapping("/profile")
public class ProfileContoller {
	
	private Services<Teacher> teacherService;
	private Services<Student> studentService;
	
	@Autowired
	public ProfileContoller(Services<Teacher> teacherService,Services<Student> studentService) {
		this.studentService = studentService;
		this.teacherService = teacherService;
	}



	@GetMapping("/teacher")
	public String TeacherProfile(@RequestParam("teacher_username") String user, Model model) {
		Optional<Teacher> teacher = teacherService.findAll().stream().filter(e-> e.getUsers().getUsername().equals(user)).findAny();
		model.addAttribute("action", "Update Teacher");
		System.out.println(teacher.get().getFirstName());
		if(teacher !=null) {
			model.addAttribute("teacher_subject", teacher.get().getSubjectList());
			model.addAttribute("teacher_lecture", teacher.get().getTeacher_lecture());
			model.addAttribute("teacher_object", teacher.get());
			model.addAttribute("teacher_schedule", teacher.get().getTeacher_schedule());	
		}
		return "teacherProfile/teacher";
	}
	
	@GetMapping("/student")
	public String StudentProfile(@RequestParam("student_username") String user, Model model) {
		
		Optional<Student> student = studentService.findAll().stream().filter(e-> e.getUsers().getUsername().equals(user)).findFirst();
		

		List<StrandAndCourse> strand_list = new ArrayList<StrandAndCourse>();

		List<Room_Shift> room_shift =	new ArrayList<Room_Shift>();

		strand_list.add(student.get().getStrandAndCourse());
		room_shift.add(student.get().getRoom_shift());
		
		// for the dropdown
		model.addAttribute("strand_list", strand_list);
		model.addAttribute("roomshift_list", room_shift);
		model.addAttribute("student_object", student.get());
		model.addAttribute("schedule_list", student.get().getRoom_shift().getRoom_ShiftSchedules());
		return "studentProfile/student";
	}
	
	
	
	

}
