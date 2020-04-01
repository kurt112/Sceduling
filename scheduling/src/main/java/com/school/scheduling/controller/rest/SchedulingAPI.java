package com.school.scheduling.controller.rest;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.scheduling.entity.Room;
import com.school.scheduling.entity.Room_Shift;
import com.school.scheduling.entity.Student;
import com.school.scheduling.entity.Teacher;
import com.school.scheduling.service.Services;

@RestController
@RequestMapping("/api")
public class SchedulingAPI {

	
	private Services<Teacher> teacherService;
	private Services<Room> roomService;
	private Services<Room_Shift> shiftService;
	private Services<Student> studentServices;
	@Autowired
	public SchedulingAPI(Services<Teacher> teacherService, Services<Room> roomService,
			Services<Room_Shift> shiftService,Services<Student> studentServices) {
		this.teacherService = teacherService;
		this.roomService = roomService;
		this.shiftService = shiftService;
		this.studentServices = studentServices;
	}
	
	@GetMapping("/teacher/count")
	private long TeacherCount() {
		return (int)teacherService.findAll().stream().distinct().count();
	}
	
	@GetMapping("/section/count")
	private long SectionCount() {
		
		return  shiftService.findAll().stream().distinct().count();
	}
	
	@GetMapping("/room/count")
	private long RoomCount() {
		return roomService.findAll().stream().distinct().count();
	}
	
	@GetMapping("/student/count")
	private long StudentCount() {
		return studentServices.findAll().stream().distinct().count();
	}
	
	





	
}
