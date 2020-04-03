package com.school.scheduling.controller.rest;

import com.school.scheduling.entity.*;
import com.school.scheduling.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SchedulingAPI {

	private Services<Teacher> teacherService;
	private Services<Room> roomService;
	private Services<Room_Shift> shiftService;
	private Services<Student> studentServices;
	private Services<Subject> subjectServices;
	private Services<StrandAndCourse> strandServices;


	@Autowired
	public SchedulingAPI(Services<Teacher> teacherService, Services<Room> roomService,
			Services<Room_Shift> shiftService, Services<Student> studentServices, Services<Subject> subjectServices,Services<StrandAndCourse> strandServices) {
		this.teacherService = teacherService;
		this.roomService = roomService;
		this.shiftService = shiftService;
		this.studentServices = studentServices;
		this.subjectServices = subjectServices;
		this.strandServices = strandServices;
	}

	@GetMapping("/teacher/count")
	private long TeacherCount() {
		return (int) teacherService.findAll().stream().distinct().count();
	}

	@GetMapping("/section/count")
	private long SectionCount() {

		return shiftService.findAll().stream().distinct().count();
	}
	@GetMapping("/subject/count")
	private long SubjectCount() {
		return subjectServices.findAll().stream().distinct().count();
	}

	@GetMapping("/room/count")
	private long RoomCount() {
		return roomService.findAll().stream().distinct().count();
	}

	@GetMapping("/student/count")
	private long StudentCount() {
		return studentServices.findAll().stream().distinct().count();
	}

	@GetMapping("/subject/top")
	public List<Top> Top_Subject(@RequestParam("value") int value) {
		List<Subject> subject_list = subjectServices.findAll();
		List<Room_Shift> shift = shiftService.findAll();
		List<Top> top_subject = new ArrayList<>();

		
		for(Subject subject: subject_list) {
			int count = 0;
			for(Room_Shift room: shift) {
				if(room.getStrandAndCourse().getSubjectList().contains(subject)) count++;
			}
			top_subject.add(new Top(subject.getSubjectName(), count));
			
		}


		Collections.sort(top_subject);
		top_subject.subList(value, top_subject.size()).clear();

		return top_subject;
	}

	@GetMapping("/strand/composition")
	public List<Top> StrandComposition() {

		List<Top> top  = new ArrayList<>();


		for(StrandAndCourse strand:strandServices.findAll()){
			int count =0;
			for(Room_Shift shift:shiftService.findAll()){
				if(shift.getStrandAndCourse() == strand) count++;
			}

			top.add(new Top(strand.getStrandName(), count));

		}


		return top.stream().filter(e-> e.qty !=0).collect(Collectors.toList());
	}

	static class Top implements Comparable<Top> {

		private String name;
		private int qty;

		public String getName() {
			return name;
		}

		public void setName(String subjectName) {
			this.name = name;
		}

		public int getQty() {
			return qty;
		}

		public void setQty(int qty) {
			this.qty = qty;
		}

		public Top(String name, int qty) {

			this.name = name;
			this.qty = qty;
		}

		@Override
		public int compareTo(Top o) {

			return o.getQty() - qty;
		}

	}

}
