package com.school.scheduling.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.scheduling.entity.StrandAndCourse;
import com.school.scheduling.entity.Subject;
import com.school.scheduling.service.Services;

@Controller
@RequestMapping("/strand")
public class StrandController {

	private Services<StrandAndCourse> strandService;
	private Services<Subject> subjectService;

	private StrandAndCourse strand;

	@Autowired
	public StrandController(Services<StrandAndCourse> strand, Services<Subject> subjectService) {
		System.out.println("im called");
		this.strandService = strand;
		this.subjectService = subjectService;
	}

	/********************** ForStrand ******************************/
	// request mapping for Strand list
	@GetMapping("/list")
	public ModelAndView Strand_List() {
		ModelAndView model = new ModelAndView("strand/strand list/strand-list");
		model.addObject("strand", strandService.findAll());
		this.strand = null;
		return model;
	}

	@GetMapping("/form")
	public ModelAndView Strand_Form() {
		StrandAndCourse strandandCourse = new StrandAndCourse();
		ModelAndView model = new ModelAndView("strand/strand list/strand-form");
		model.addObject("strand_object", strandandCourse);
		this.strand = strandandCourse;
		model.addObject("action", "Save Strand");
		return model;
	}

	// request mapping for save in strand and course
	@PostMapping("/save")
	public ModelAndView Strand_Add(@Valid @ModelAttribute("strand_object") StrandAndCourse strand) {
		ModelAndView model = new ModelAndView("redirect:/strand/form");
		this.strand.setStrandName(strand.getStrandName());
		strandService.save(this.strand);
		this.strand = null;

		return model;
	}

	@GetMapping("/update")
	public ModelAndView Strand_Update(@RequestParam("strand_id") int theId) {

		ModelAndView model = new ModelAndView("strand/strand list/strand-form");
		StrandAndCourse strand_model = this.strand;
		System.out.println("The Id -> " + theId);
		System.out.println("the strand in update " + this.strand);
		if (strand_model == null) {
			strand_model = strandService.findbyId(theId);
			if (strand_model == null)
				strand_model = new StrandAndCourse();
		}

		System.out.println("The strand name in update -> " + strand_model.getStrandName());

		this.strand = strand_model;
		model.addObject("strand_object", strand_model);
		model.addObject("strand_subject", strand_model.getSubjectList());
		model.addObject("action", "Update Strand");
		return model;
	}

	@GetMapping("/delete")
	private String Strand_Delete(@RequestParam("strand_id") int theId, Model model) {

		StrandAndCourse strand = strandService.findbyId(theId);
		model.addAttribute("action", "Save Strand");

		if (strand.getRoom_shiftList().size() > 0) {
			model.addAttribute("strandRoomShift", strand.getRoom_shiftList().size());
		}

		strandService.deleteById(theId);
		return "redirect:/strand/form";
	}

	@GetMapping("/delete_list")
	private String Strand_DeleteList(@RequestParam("strand_id") int theId) {

		strandService.deleteById(theId);

		return "redirect:/strand/form";
	}

	@GetMapping("/subjects")
	public String Strand_Subjects(Model model) {

		List<StrandAndCourse> list = strandService.findAll();
		
		list.forEach(e -> 
			e.getSubjectList().forEach(f->{
				if(f.getSubjectUnit() == null || f.getSubjectUnit().isEmpty()) f.setSubjectUnit("N/A");
			})
		);
		
		
		model.addAttribute("strand", list);
		return "strand/strand subjects/strand-subjects";
	}

	/********************** ForStrand Subjects ******************************/

	@GetMapping("/subject/list")
	public String StrandSubject_list(Model theModel, @ModelAttribute("strand_subject") StrandAndCourse strand) {
		strand = this.strand;
		System.out.println("The model" + strand.getStrandName());
		if (strand.getStrandName() != null) {
			List<Subject> subjectdb = subjectService.findAll();
			List<Subject> unique = new ArrayList<Subject>();

			for (int i = 0; i < subjectdb.size(); i++) {
				boolean duplicate = false;
				for (Subject sbj : strand.getSubjectList()) {
					if (subjectdb.get(i).getId() == sbj.getId()) {
						duplicate = true;
						break;
					}
				}

				if (duplicate == false) {
					unique.add(subjectdb.get(i));
				}
			}
			theModel.addAttribute("subjects", unique);
		} else {
			System.out.println("Did i call?");
			theModel.addAttribute("subjects", subjectService.findAll());
		}
		theModel.addAttribute("strand_object", strand);

		return "subject/subject add strand/add-subject-strand";
	}

	@PostMapping("/subject/save")
	public String StrandSubject_form(@ModelAttribute("strand_subject") StrandAndCourse strand, Model theModel) {

		if (this.strand.getSubjectList() != null) {
			if (strand.getSubjectList() != null)
				this.strand.getSubjectList().addAll(strand.getSubjectList());
		} else {
			this.strand.setSubjectList(strand.getSubjectList());
		}

		strandService.save(this.strand);
		theModel.addAttribute("strand_object", this.strand);
		theModel.addAttribute("strand_subject", this.strand.getSubjectList());
		theModel.addAttribute("action", "Update Strand");
		// strandService.save(this.strand);
		return "strand/strand list/strand-form";
	}

	@GetMapping("/subject/delete")
	private String StrandSubject_delete(@RequestParam("subject_id") int theid, Model model) {
		this.strand.getSubjectList().removeIf(e -> e.getId() == theid);
		model.addAttribute("strand_object", this.strand);
		model.addAttribute("strand_subject", this.strand.getSubjectList());
		strandService.save(this.strand);
		model.addAttribute("action", "Update Strand");
		return "strand/strand list/strand-form";
	}
}
