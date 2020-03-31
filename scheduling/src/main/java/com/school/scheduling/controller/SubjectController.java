package com.school.scheduling.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.school.scheduling.entity.Subject;
import com.school.scheduling.service.Services;

@Controller
@RequestMapping("/subject")
public class SubjectController {

	private Services<Subject> subjectService;
	private int back =0;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@Autowired
	public SubjectController(Services<Subject> subjectService) {
		this.subjectService = subjectService;
	}

	@GetMapping("/form")
	public String SubjectList(Model theModel) {
		Subject subject = new Subject();
		
		// for the model attribute
		theModel.addAttribute("subject", subject);
		
		// for the back button
		theModel.addAttribute("back", back);
		
		// if not show the delete button
		theModel.addAttribute("action","Save Subject");
		
		return "subject/subject list/subject-list-form";
	}

	@GetMapping("/list")
	public String SubjectContent(Model theModel) {
		theModel.addAttribute("subjects", subjectService.findAll());
		back = -1;
		return "subject/subject list/subject-list";
	}

	// to save an entity
	@PostMapping("/save")
	public String SubjectAdd(@Valid @ModelAttribute("subject") Subject subject, BindingResult binding, Model theModel) {

		// for the list of table
		theModel.addAttribute("subjects", subjectService.findAll());
		
		if (binding.hasErrors()) {
			System.out.println(binding.getFieldError());
			System.out.println(binding.toString());
			return "subject/subject list/subject-list-form";
		}
		// back -2 because this save will redirect twice in the form
		back = -2;
		subjectService.save(subject);
		return "redirect:/subject/f	orm";
	}

	// to delete an entity
	@GetMapping("/delete")
	public String SubjectDelete(@RequestParam("subject_id") int theiD) {

		subjectService.deleteById(theiD);

		return "redirect:/subject/form";
	}

	@GetMapping("/update")
	public String SubjectUpdate(@RequestParam("subject_id") int theiD, Model theModel) {
		
		Subject subject = subjectService.findbyId(theiD);
		
		theModel.addAttribute("strand_list", subject.getStrandAndCourseList());
		
		theModel.addAttribute("subject", subject);
		theModel.addAttribute("back", back);
		

		theModel.addAttribute("action","Update Subject");
		return "subject/subject list/subject-list-form";
	}

	/******************************
	 * Deleted or udpate in the main view
	 ***********************************************/

	@GetMapping("/delete_main")
	public String SubjectDeleteMain(@RequestParam("subject_id") int theiD) {
		subjectService.deleteById(theiD);
		return "redirect:/subject/list";

	}
	
	
	/************************** mapping for subject schedule ************************/
	
	@GetMapping("/schedule/form")
	public String SubjecScheduleFormtList() {
		return "subject/subject schedule/subject-schedule-form";
	}

	@GetMapping("/schedule/list")
	public String SubjectScheduleList(Model model) {
	
		model.addAttribute("subject_schedule",subjectService.findAll());
		return "subject/subject schedule/subject-schedule";
	}

	// to save an entity
	@PostMapping("/schedule/save")
	public String SubjectScheduleAdd() {
		return "redirect:/subject/schedule/form";
	}

	// to delete an entity
	@GetMapping("/schedule/delete")
	public String SubjectScheduleDelete() {

		return "redirect:/subject/schedule/form";
	}

	@GetMapping("/schedule/update")
	public String SubjectScheduleUpdate() {
		return "redirect:/subject/schedule/form";
	}
	
	/************************** mapping for adding subject in the strand ************************/


}
