package com.school.scheduling.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.scheduling.SchedulingAlgorithm.GenerateTeacher_Schedule;
import com.school.scheduling.entity.Authorities;
import com.school.scheduling.entity.BreakTime;
import com.school.scheduling.entity.Room_ShiftSchedule;
import com.school.scheduling.entity.Subject;
import com.school.scheduling.entity.Teacher;
import com.school.scheduling.entity.Teacher_Lecture;
import com.school.scheduling.service.Services;

import javax.validation.Valid;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	private Services<Teacher> teacherService;
	private Services<Subject> subjectService;
	private Services<BreakTime> breakServices;
	private Services<Room_ShiftSchedule> scheduleServices;
	private Services<Teacher_Lecture> lectureServices;
	private Teacher teacher;

	boolean create_sched = false;

	@Autowired
	public TeacherController(Services<Teacher> teacherService, Services<Subject> subjectService,
			Services<BreakTime> breakServices, Services<Room_ShiftSchedule> scheduleServices,
			Services<Teacher_Lecture> lectureServices) {
		this.scheduleServices = scheduleServices;
		this.teacherService = teacherService;
		this.subjectService = subjectService;
		this.breakServices = breakServices;
		this.lectureServices = lectureServices;
	}

	/********************** ForTeacher ******************************/
	@GetMapping("/list")
	public String Teacher_List(Model model) {

		model.addAttribute("teacher_list", teacherService.findAll());
		return "teacher/teacher information/teacher-information";
	}

	@GetMapping("/form")
	public String Teacher_Form(Model model) {
		model.addAttribute("teacher_object", new Teacher());

		model.addAttribute("action", "Save Teacher");
		return "teacher/teacher information/teacher-information-form";
	}

	@PostMapping("/save")
	public String Teacher_Save(@Valid @ModelAttribute("teacher_object") Teacher teacher, BindingResult binding) {
		if (binding.hasErrors()) {
			return "teacher/teacher information/teacher-information-form";
		}
		BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();

		if (teacher.getId() == 0) {

			teacher.getUsers().add_Role(new Authorities(teacher.getUsers().getUsername(), "TEACHER"));
			teacher.getUsers().setEnabled(1);
			teacher.getUsers().setPassword(encrypt.encode(teacher.getUsers().getPassword()));
		}else {
			if(teacher.getUsers().getPassword()!=null) {
				teacher.getUsers().setPassword(encrypt.encode(teacher.getUsers().getPassword()));
				teacher.getUsers().setEnabled(1);
			}
		}
		
		
		
		teacherService.save(teacher);
		this.teacher = null;
		return "redirect:/teacher/form";
	}

	@GetMapping("/update")
	public String Teacher_Update(@RequestParam("teacher_id") int theId, Model model) {
		Teacher teacher = teacherService.findbyId(theId);

		model.addAttribute("action", "Update Teacher");
		model.addAttribute("teacher_subject", teacher.getSubjectList());
		model.addAttribute("teacher_lecture", teacher.getTeacher_lecture());
		model.addAttribute("teacher_object", teacher);
		model.addAttribute("teacher_schedule", teacher.getTeacher_schedule());
		
		this.teacher = teacher;
		return "teacher/teacher information/teacher-information-form";
	}

	@GetMapping("/deleteMain")
	public String Teacher_DeleteMain(@RequestParam("teacher_id") int theId) {
		Teacher teacher = teacherService.findbyId(theId);

		if (teacher.getTeacher_lecture() != null) {
			teacher.getTeacher_lecture().forEach(e -> {
				e.getBreaktime_teacherList().forEach(f -> f.setTeacher_lecture(null));
				lectureServices.deleteById(e.getId());
			});
		}

		if (teacher.getSubjectList() != null) {
			teacher.getSubjectList().removeAll(teacher.getSubjectList());
		}

		teacherService.deleteById(theId);

		return "redirect:/teacher/list";
	}

	/********************** ForTeacherBreak ******************************/

	@GetMapping("/break/list")
	public String TeacherBreak_List(Model model) {
		model.addAttribute("teachers", teacherService.findAll());
		return "teacher/teacher breaktime/teacher-breaktime";
	}

	@GetMapping("/break/list/add")
	public String TeacherBreak_Choose(@RequestParam("lecture_id") int id, Model model) throws ParseException {

		Teacher_Lecture teacher_time = lectureServices.findbyId(id);

		DateFormat dateFormat = new SimpleDateFormat("HH:mm");

		Calendar shift_startTime = Calendar.getInstance();
		Calendar shift_endTime = Calendar.getInstance();

		Calendar shift_break_start = Calendar.getInstance();
		Calendar shift_break_end = Calendar.getInstance();

		List<BreakTime> break_list = new ArrayList<>();

		//t he time of the shift list
		shift_startTime.setTime(dateFormat.parse(teacher_time.getStartTime()));
		shift_endTime.setTime(dateFormat.parse(teacher_time.getEndTime()));

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

		break_list.removeAll(teacher_time.getBreaktime_teacherList());

		model.addAttribute("teacher_breaks", break_list);

		model.addAttribute("teacher_lecture", teacher_time);

		System.out.println("The id -> " + teacher_time.getId());

		return "teacher/teacher breaktime/teacher-break-check";
	}

	@GetMapping("/break/form")
	public String TeacherBreak_Form() {
		return "teacher/teacher breaktime/teacher-breaktime-form";
	}

	@PostMapping("/break/save")
	public String TeacherBreak_Save(@ModelAttribute("teacher_lecture") Teacher_Lecture teacher) {
		Teacher_Lecture teacher_lecture = lectureServices.findbyId(teacher.getId());

		if (teacher_lecture.getBreaktime_teacherList() != null) {
			if(teacher.getBreaktime_teacherList() !=null)teacher_lecture.getBreaktime_teacherList().addAll(teacher.getBreaktime_teacherList());

			lectureServices.save(teacher_lecture);
		} else {
			lectureServices.save(teacher);
		}
		return "redirect:/teacher/update?teacher_id=" + teacher_lecture.getTeacher().getId();
	}

	@GetMapping("/break/update")
	public String TeacherBreak_Update() {
		return "redirect:/teacher/break/form";
	}

	@GetMapping("/break/delete")
	public String TeacherBreak_Delete(@RequestParam("break_id") int break_id,
			@RequestParam("teacher_id") int teacher_id) {
		Teacher teacher = teacherService.findbyId(teacher_id);
		teacher.getTeacher_lecture().removeIf(e -> e.getBreaktime_teacherList().removeIf(f -> f.getId() == break_id));

		teacherService.save(teacher);
		return "redirect:/teacher/break/list";
	}
	
	@GetMapping("/break/deleteForm")
	public String TeacherBreak_DeleteForm(@RequestParam("break_id") int break_id,
			@RequestParam("teacher_id") int teacher_id) {
		Teacher teacher = teacherService.findbyId(teacher_id);
		teacher.getTeacher_lecture().removeIf(e -> e.getBreaktime_teacherList().removeIf(f -> f.getId() == break_id));

		teacherService.save(teacher);
		return "redirect:/teacher/update?teacher_id="+teacher.getId();
	}
	
	
	
	@GetMapping("/schedule/deleteSchedule")
	public String DeleteSchedule() {
		teacherService.findAll().forEach(e-> e.setSubject_load(0));
		scheduleServices.findAll().forEach(e-> {
			 e.setTeacher(null);
			 scheduleServices.save(e);
		});
		return "redirect:/teacher/schedule/list";
	}

	/************************** For teacher schedule ************************/
	int zero = 0;

	@GetMapping("/schedule/generateSchedule")
	public String GenerateSchedule_List() {

		List<Room_ShiftSchedule> schedule_tth = scheduleServices.findAll().stream()
				.filter(e -> e.getLecture_day().equals("TTH")).collect(Collectors.toList());
		List<Room_ShiftSchedule> schedule_mwf = scheduleServices.findAll().stream()
				.filter(e -> e.getLecture_day().equals("MWF")).collect(Collectors.toList());

		List<Teacher_Lecture> teacher_tth = lectureServices.findAll().stream()
				.filter(e -> e.getLectureDay().equals("TTH")).collect(Collectors.toList());
		List<Teacher_Lecture> teacher_wmf = lectureServices.findAll().stream()
				.filter(f -> f.getLectureDay().equals("MWF")).collect(Collectors.toList());
		
		GenerateTeacher_Schedule scheduletth = new GenerateTeacher_Schedule(teacher_tth, schedule_tth, lectureServices);
		GenerateTeacher_Schedule schedulewmf = new GenerateTeacher_Schedule(teacher_wmf, schedule_mwf, lectureServices);
		
		scheduletth.Schedule();
		schedulewmf.Schedule();
		
		
		return "redirect:/teacher/schedule/list";
	}

	@GetMapping("/schedule/list")
	public String TeacherSchedule_List(Model model) {

		List<Teacher> teacher = teacherService.findAll();


		model.addAttribute("teachers", teacher);

		return "teacher/teacher schedule/teacher-schedule";
	}

	/************************** For teacher Suject ************************/

	// will redirect to you the possible subject of the teacher
	// if the teacher have that subject then the subject will filter
	@GetMapping("/subject/list")
	public String Teacher_SubjectList(@ModelAttribute("teacher_object") Teacher teacher, Model model) {
		teacher = this.teacher;
		List<Subject> subjectdb = subjectService.findAll();

		List<Subject> teacher_subject = teacher.getSubjectList();

		subjectdb.removeAll(teacher_subject);

		model.addAttribute("subjects", subjectdb);

		model.addAttribute("teacher_object", teacher);

		return "subject/subject add teacher/add-subject-teacher";
	}

	// adding all the subject click in the subject list
	@PostMapping("/subject/add")
	public String Teacher_SubjectAdd(@ModelAttribute("teacher_obejct") Teacher teacher, Model model) {

		if (this.teacher.getSubjectList() != null) {
			if (teacher.getSubjectList() != null)
				this.teacher.getSubjectList().addAll(teacher.getSubjectList());
		} else {
			this.teacher.setSubjectList(teacher.getSubjectList());
		}
		teacherService.save(this.teacher);
		return "redirect:/teacher/update?teacher_id=" + this.teacher.getId();
	}

	@GetMapping("/subject/delete")
	public String Teacher_SubjectDelete(@RequestParam("subject_id") int subject_id, Model model) {
		this.teacher.getSubjectList().removeIf(e -> e.getId() == subject_id);
		teacherService.save(this.teacher);
		model.addAttribute("action", "Update Teacher");
		model.addAttribute("teacher_subject", this.teacher.getSubjectList());
		model.addAttribute("teacher_object", this.teacher);

		return "teacher/teacher information/teacher-information-form";
	}

	@GetMapping("/subjects")
	public String Teacher_Subject(Model model) {

		List<Teacher> teacher_list = teacherService.findAll();
		model.addAttribute("teacher_list", teacher_list);
		return "teacher/teacher subjects/teacher-subjects";
	}

	@GetMapping("/lecture/form")
	public String TeacherLecture_Form(Model model) {

		model.addAttribute("teacher_lecture", new Teacher_Lecture());
		if (this.teacher != null)
			model.addAttribute("teacher_list", this.teacher);
		else {
			model.addAttribute("teacher_list", teacherService.findAll());
		}
		model.addAttribute("action", "Save Lecture");
		return "teacher/teacher lecture/teacher-lecture-form";
	}

	@GetMapping("/lecture/update")
	public String TeacherLecture_update(@RequestParam("lecture_id") int id, Model model) {
		Teacher_Lecture lecture = lectureServices.findbyId(id);

		model.addAttribute("teacher_lecture", lecture);
		model.addAttribute("action", "Update Lecture");
		model.addAttribute("teacher_list", teacherService.findAll());
		return "teacher/teacher lecture/teacher-lecture-form";
	}
	

	@PostMapping("/lecture/save")
	public String Teacher_Lecture_Save(@ModelAttribute("teacher_lecture") Teacher_Lecture teacher_lecture) {

		lectureServices.save(teacher_lecture);

		return "redirect:/teacher/update?teacher_id=" + teacher_lecture.getTeacher().getId();
	}

	@GetMapping("/lecture/list")
	public String TeacherLecture_List(Model model) {
		model.addAttribute("teacher_list", teacherService.findAll());
		this.teacher = null;
		return "teacher/teacher lecture/teacher-lecture-list";

	}

	@GetMapping("/lecture/DeleteMain")
	public String TeacherLecture_Delete(@RequestParam("lecture_id") int id, Model model) {

		lectureServices.deleteById(id);

		return "redirect:/teacher/lecture/list";

	}
	
	@GetMapping("/lecture/deleteForm")
	public String TeacherLecture_Form(@RequestParam("lecture_id") int id, Model model) {
		Teacher_Lecture lecture = lectureServices.findbyId(id);
		lectureServices.deleteById(id);

		return "redirect:/teacher/update?teacher_id="+lecture.getTeacher().getId();

	}

}
