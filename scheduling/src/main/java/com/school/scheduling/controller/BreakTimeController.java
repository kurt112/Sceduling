package com.school.scheduling.controller;

import com.school.scheduling.entity.BreakTime;
import com.school.scheduling.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
		model.addAttribute("action", "Save BreakTime");
		return "breaktime/breaktime-form";
	}
	
	@GetMapping("/update")
	public String BreakTime_Update(@RequestParam("break_id") int id, Model model) {
		
		BreakTime breaktime = breakService.findbyId(id);

		model.addAttribute("teacher_list", breaktime.getTeacher_lecture());
		model.addAttribute("room_shifts", breaktime.getRoom_shift());
		model.addAttribute("break_object", breaktime);
		model.addAttribute("action", "Update");
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
	public String BreakTime_Add(@Valid @ModelAttribute("break_object") BreakTime breaks, BindingResult binding) {
		if(binding.hasErrors()){
			return "breaktime/breaktime-form";
		}
		breakService.save(breaks);
		return "redirect:/breaktime/form";
	}

}
