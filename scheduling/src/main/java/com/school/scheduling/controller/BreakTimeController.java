package com.school.scheduling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.context.Theme;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.scheduling.entity.BreakTime;
import com.school.scheduling.service.Services;

@Controller
@RequestMapping("/breaktime")
public class BreakTimeController {
	private Services<BreakTime> breakService;

	@Autowired
	public BreakTimeController(Services<BreakTime> breakService) {
		this.breakService = breakService;
	}

	@GetMapping("/list")
	public String BreakList(Model model) {
		List<BreakTime> breaktime = breakService.findAll();
		model.addAttribute("break_list", breaktime);
		return "breaktime/breaktime-list";
	}
	
	@GetMapping("/form")
	public String BreakTime_Form(Model model) {
		model.addAttribute("break_object",new BreakTime());
		
		return "breaktime/breaktime-form";
	}
	
	@GetMapping("/update")
	public String BreakTime_Update(@RequestParam("break_id") int id, Model model) {
		
		BreakTime breaktime = breakService.findbyId(id);

		model.addAttribute("teacher_list", breaktime.getTeacher());
		model.addAttribute("room_shifts", breaktime.getRoom_shift());
		model.addAttribute("break_object", breaktime);
		
		return "breaktime/breaktime-form";
	}
	
	@GetMapping("/deleteMain")
	public String BreakTime_DeleteMain(@RequestParam("break_id") int id) {
		breakService.deleteById(id);
		return "redirect:/breaktime/list";
	}
	
	@GetMapping("/delete")
	public String BreakTime_Delete(@RequestParam("break_id") int id) {
		breakService.deleteById(id);
		return "redirect:/breaktime/form";
	}
	

	// request mapping for room break save
	@PostMapping("/save")
	public String BreakTime_Add(@ModelAttribute("break_object") BreakTime breaks, Model model) {
		breakService.save(breaks);
		return "redirect:/breaktime/form";
	}

}
