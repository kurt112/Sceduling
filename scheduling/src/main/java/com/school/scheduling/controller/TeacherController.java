package com.school.scheduling.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.scheduling.entity.Authorities;
import com.school.scheduling.entity.BreakTime;
import com.school.scheduling.entity.Subject;
import com.school.scheduling.entity.Teacher;
import com.school.scheduling.service.Services;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	private Services<Teacher> teacherService;
	private Services<Subject> subjectService;
	private Services<BreakTime> breakServices;
	private Teacher teacher;
	private Teacher delete_teacher;

	@Autowired
	public TeacherController(Services<Teacher> teacherService,Services<Subject> subjectService,Services<BreakTime> breakServices) {
		this.teacherService = teacherService;
		this.subjectService = subjectService;
		this.breakServices = breakServices;
	}

	/**********************    ForTeacher     ******************************/
	@GetMapping("/list")
	public String Teacher_List(Model model) {
		if(delete_teacher != null) {
			teacherService.delete(teacher);
			delete_teacher = null;
		}
		model.addAttribute("teacher_list", teacherService.findAll());
		return "teacher/teacher information/teacher-information";
	}

	@GetMapping("/form")
	public String Teacher_Form(Model model) {
		model.addAttribute("teacher_object",new Teacher());
		
		model.addAttribute("action", "Save Teacher");
		return "teacher/teacher information/teacher-information-form";
	}
	@PostMapping("/save")
	public String Teacher_Save(@ModelAttribute("teacher_object") Teacher teacher) {
		BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();
		teacher.getUsers().add_Role(new Authorities(teacher.getUsers().getUsername(),"TEACHER"));
		teacher.getUsers().setEnabled(1);
		teacher.getUsers().setPassword(encrypt.encode(teacher.getUsers().getPassword()));
		teacher.setRemainingTime(teacher.getStartTime());
		teacherService.save(teacher);
		this.teacher = null;
		return "redirect:/teacher/form";
	}
	@GetMapping("/update")
	public String Teacher_Update(@RequestParam("teacher_id") int theId, Model model) {
		Teacher teacher = teacherService.findbyId(theId);
	
		model.addAttribute("action", "Update Teacher");
		model.addAttribute("teacher_subject",teacher.getSubjectList());
		model.addAttribute("teacher_break", teacher.getBreaktime_teacherList());
		model.addAttribute("teacher_object", teacher);
		teacherService.save(teacher);
		this.teacher = teacher;
		return "teacher/teacher information/teacher-information-form";
	}
	
	@GetMapping("/deleteMain")
	public String Teacher_DeleteMain(@RequestParam("teacher_id") int theId) {
		Teacher teacher = teacherService.findbyId(theId);
		if(teacher.getBreaktime_teacherList() !=null && teacher.getSubjectList() !=null) {
			teacher.getBreaktime_teacherList().removeAll(teacher.getBreaktime_teacherList());
			teacher.getSubjectList().removeAll(teacher.getSubjectList());
			teacherService.save(teacher);
			delete_teacher = teacher;
		}
		teacherService.deleteById(theId);	
	
		return "redirect:/teacher/list";
	}
	@GetMapping("/delete")
	public String Teacher_Delete() {
		return "redirect:/teacher/form";
	}

	/**********************    ForTeacherBreak     ******************************/

	@GetMapping("/break/list")
	public String TeacherBreak_List(Model model) {
		model.addAttribute("teacher_break", teacherService.findAll());
		return "teacher/teacher breaktime/teacher-breaktime";
	}
	
	@GetMapping("/break/list/add")
	public String TeacherBreak_Choose(@ModelAttribute("teacher_object") Teacher teacher,Model model) {
		teacher = this.teacher;
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");

		Calendar shift_startTime = Calendar.getInstance();
		Calendar shift_endTime = Calendar.getInstance();

		Calendar shift_break_start = Calendar.getInstance();
		Calendar shift_break_end = Calendar.getInstance();

		List<BreakTime> break_list = new ArrayList<BreakTime>();

		try {

			// he time of the shift list
			shift_startTime.setTime(dateFormat.parse(teacher.getStartTime()));
			shift_endTime.setTime(dateFormat.parse(teacher.getEndTime()));

			// it will check if the break is between the time of the room shift
			// .collect(Collectors.toList());
			for (BreakTime shift_break : breakServices.findAll()) {

				// converting the time of the break in the break

				// start time of the break
				shift_break_start.setTime(dateFormat.parse(shift_break.getStart_time()));

				// end tiem of the break
				shift_break_end.setTime(dateFormat.parse(shift_break.getEnd_time()));

				// if the start time and end time of the break is in the middle then we will add
				// it

				if (shift_startTime.getTime().before(shift_break_start.getTime())
						&& shift_endTime.getTime().after(shift_break_end.getTime())) {
					break_list.add(shift_break);
				}
			}
		} catch (ParseException e) {
			// TODO: handle exception
		}

		if (teacher.getBreaktime_teacherList() != null) {
			List<BreakTime> breaks = new ArrayList<BreakTime>();

			for (BreakTime break_time : break_list) {
				System.out.println(break_time);
				boolean add = true;
				for (BreakTime break_room : teacher.getBreaktime_teacherList()) {
					if (break_time.getId() == break_room.getId()) {
						add = false;
						break;
					}

				}
				if (add)
					breaks.add(break_time);

			}
			model.addAttribute("teacher_breaks", breaks);
		} else
			model.addAttribute("teacher_breaks", break_list);

		model.addAttribute("teacher_object", teacher);
	
		return "teacher/teacher breaktime/teacher-break-check";
	}
	@GetMapping("/break/form")
	public String TeacherBreak_Form() {
		return "teacher/teacher breaktime/teacher-breaktime-form";
	}
	@PostMapping("/break/save")
	public String TeacherBreak_Save(@ModelAttribute("teacher_obejct") Teacher teacher, Model model) {
//		this.roomShift.getRoom_shift_breakTimeList().addAll(roomShift.getRoom_shift_breakTimeList());
		teacher.getBreaktime_teacherList().forEach(e -> this.teacher.getBreaktime_teacherList().add(e));

//		System.out.println(roomShift.toString());

		teacherService.save(this.teacher);

		
		
		model.addAttribute("action", "Update Teacher");
		model.addAttribute("teacher_subject",this.teacher.getSubjectList());
		model.addAttribute("teacher_object", this.teacher);
		model.addAttribute("teacher_break", this.teacher.getBreaktime_teacherList());
		return "teacher/teacher information/teacher-information-form";
	}
	@GetMapping("/break/update")
	public String TeacherBreak_Update() {
		return "redirect:/teacher/break/form";
	}
	@GetMapping("/break/delete")
	public String TeacherBreak_Delete(@RequestParam("break_id") int break_id, @RequestParam("teacher_id") int teacher_id) {
		Teacher teacher = teacherService.findbyId(teacher_id);
		teacher.getBreaktime_teacherList().removeIf(e -> e.getId() == break_id);
		teacherService.save(teacher);
		return "redirect:/teacher/break/list";
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
	
	/************************** For teacher Suject ************************/

	// will redirect to you the possible subject of the teacher
	// if the teacher have that subject then the subject will filter
	@GetMapping("/subject/list")
	public String Teacher_SubjectList(@ModelAttribute("teacher_object") Teacher teacher,Model model) {
		teacher = this.teacher;
		System.out.println("the tacher " + teacher);
		if(teacher.getFirstName() !=null) {
			List<Subject> subjectdb = subjectService.findAll();
			List<Subject> unique = new ArrayList<Subject>();
			
			for (int i = 0; i < subjectdb.size(); i++) {
				boolean duplicate = false;
				for (Subject sbj : teacher.getSubjectList()) {
					if (subjectdb.get(i).getId() == sbj.getId()) {
						duplicate = true;
						break;
					}
				}

				if (duplicate == false) {
					unique.add(subjectdb.get(i));
				}
			}
			model.addAttribute("subjects", unique);
		}else {
			System.out.println("Did i call?");
			model.addAttribute("subjects", subjectService.findAll());
		}
		model.addAttribute("teacher_object", teacher);
		
		return "subject/subject add teacher/add-subject-teacher";
	}
	
	// adding all the subject click in the subject list
	@PostMapping("/subject/add")
	public String Teacher_SubjectAdd(@ModelAttribute("teacher_obejct") Teacher teacher, Model model) {
		
		if(this.teacher.getSubjectList() != null) {
			if(teacher.getSubjectList() !=null) this.teacher.getSubjectList().addAll(teacher.getSubjectList());
		}else {
			this.teacher.setSubjectList(teacher.getSubjectList());
		}
		model.addAttribute("teacher_object", this.teacher);
		teacherService.save(this.teacher);
		model.addAttribute("action", "Update Teacher");
		return "subject/subject add teacher/add-subject-teacher";
	}
	
	@GetMapping("/subject/delete")
	public String Teacher_SubjectDelete(@RequestParam("subject_id") int subject_id, Model model) {
		this.teacher.getSubjectList().removeIf(e -> e.getId() == subject_id);
		teacherService.save(this.teacher);
		model.addAttribute("action", "Update Teacher");
		model.addAttribute("teacher_subject",this.teacher.getSubjectList());
		model.addAttribute("teacher_object", this.teacher);
		
		return "teacher/teacher information/teacher-information-form";
	}
}
