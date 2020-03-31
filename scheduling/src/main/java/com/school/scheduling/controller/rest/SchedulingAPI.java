package com.school.scheduling.controller.rest;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.scheduling.entity.Room;
import com.school.scheduling.entity.Room_Shift;
import com.school.scheduling.entity.Teacher;
import com.school.scheduling.service.Services;

@RestController
@RequestMapping("/api")
public class SchedulingAPI {

	
	private Services<Teacher> teacherService;
	private Services<Room> roomService;
	private Services<Room_Shift> shiftService;
	
	@Autowired
	public SchedulingAPI(Services<Teacher> teacherService, Services<Room> roomService,
			Services<Room_Shift> shiftService) {
		this.teacherService = teacherService;
		this.roomService = roomService;
		this.shiftService = shiftService;
	}
	
	@GetMapping("/teacher_count")
	private int teacher_count() {
		
		return (int)teacherService.findAll().stream().distinct().count();
	}
	
	
	





	
}
