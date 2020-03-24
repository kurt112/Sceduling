package com.school.scheduling.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.scheduling.entity.Authorities;
import com.school.scheduling.entity.Room;
import com.school.scheduling.entity.Room_Shift;
import com.school.scheduling.entity.StrandAndCourse;
import com.school.scheduling.entity.Student;
import com.school.scheduling.service.RoomShiftService;
import com.school.scheduling.service.Services;

@Controller
@RequestMapping("/student")
public class StudentController {

	private Services<Student> studentservice;
	private Services<Room_Shift> roomshift_service;
	private Services<StrandAndCourse> strand_service;

	@Autowired
	public StudentController(Services<Student> studentservice, Services<Room_Shift> roomshift_service,
			Services<StrandAndCourse> strand_service) {
		this.studentservice = studentservice;
		this.roomshift_service = roomshift_service;
		this.strand_service = strand_service;
	}

	/************************ For the studnet ******************************/

	@GetMapping("/list")
	public String Student_List(Model model) {
		List<Student> student_list = studentservice.findAll();

		student_list.forEach(e-> {
			if(e.getRoom_shift()==null) {
				Room_Shift room_Shift = new Room_Shift();
				
				room_Shift.setRoom(new Room("N/A"));
				room_Shift.setShiftName("N/A");
				room_Shift.setGrade("N/A");
				room_Shift.setSection("N/A");
				e.setRoom_shift(room_Shift);
			}
		});
		student_list.sort(
				(o1, o2) -> o1.getRoom_shift().getShiftName().compareToIgnoreCase(o2.getRoom_shift().getShiftName()));
		model.addAttribute("student_list", student_list);
		return "student/student list/student-list";
	}

	@GetMapping("/form")
	public String Student_Form(Model model) {

		List<StrandAndCourse> strand_list = strand_service.findAll();

		List<Room_Shift> room_shift = roomshift_service.findAll();

		strand_list.sort(((o1, o2) -> o1.getStrandName().compareToIgnoreCase(o2.getStrandName())));
		room_shift.sort((o1, o2) -> o1.getRoom().getRoomName().compareToIgnoreCase(o2.getRoom().getRoomName()));

		// for the dropdown
		model.addAttribute("strand_list", strand_list);
		model.addAttribute("roomshift_list", room_shift);

		// the object in the form
		model.addAttribute("student_object", new Student());

		model.addAttribute("action", "Save Student");
		
		return "student/student list/student-form";
	}

	@PostMapping("/save")
	public String Student_Add(@ModelAttribute("student_object") Student student) {
		BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();
		student.getUsers().add_Role(new Authorities(student.getUsers().getUsername(), "STUDENT"));
		student.getUsers().setPassword(encrypt.encode(student.getUsers().getPassword()));

		studentservice.save(student);
		return "redirect:/student/form";
	}

	@GetMapping("/delete")
	public String Student_Delete(@ModelAttribute("student_id") int theId) {
		studentservice.deleteById(theId);
		return "redirect:/student/form";
	}

	@GetMapping("/update")
	public String Student_Update(@RequestParam("student_id") int theId, Model model) {
		Student student = studentservice.findbyId(theId);

		// the object in the form
		model.addAttribute("student_object", student);

		List<StrandAndCourse> strand_list = strand_service.findAll();

		List<Room_Shift> room_shift = roomshift_service.findAll();

		strand_list.sort(((o1, o2) -> o1.getStrandName().compareToIgnoreCase(o2.getStrandName())));
		room_shift.sort((o1, o2) -> o1.getRoom().getRoomName().compareToIgnoreCase(o2.getRoom().getRoomName()));

		// for the dropdown
		model.addAttribute("strand_list", strand_list);
		model.addAttribute("roomshift_list", room_shift);
		model.addAttribute("action", "Update Student");
		return "student/student list/student-form";
	}

	/************************
	 * For the Schedule of student
	 ******************************/
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
