package com.school.scheduling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.scheduling.entity.Room;
import com.school.scheduling.entity.Room_Shift;
import com.school.scheduling.entity.Room_Shift_BreakTime;
import com.school.scheduling.entity.Subject;
import com.school.scheduling.service.Services;

@Controller()
@RequestMapping("/room")
public class RoomController {

	/********************** For Room list ******************************/

	private Services<Room> roomService;
	private Services<Room_Shift> roomShiftService;
	private Services<Room_Shift_BreakTime> roomBreakTime;
	
	private Room room;

	@Autowired
	public RoomController(Services<Room> roomService, Services<Room_Shift> roomShiftService,
			Services<Room_Shift_BreakTime> roomBreakTime) {

		this.roomService = roomService;
		this.roomShiftService = roomShiftService;
		this.roomBreakTime = roomBreakTime;
	}

	/********************************* Mapping for Room ******************/

	// request mapping for room list
	@GetMapping("/list")
	public String RoomList(Model model) {
		model.addAttribute("rooms", roomService.findAll());
		
		
		
		
		return "room/room list/room-list";
	}

	// request mapping for room add
	@GetMapping("/form")
	public String Room_Form(Model model) {
		this.room = new Room();
		model.addAttribute("room_object", this.room);
		return "room/room list/room-form";
	}
	

	@PostMapping("/save")
	public String Room_Save(Model model) {
		model.addAttribute("room_object", new Room());
		return "redirect:/room/form";
	}

	@GetMapping("/update")
	private ModelAndView Room_Update(@RequestParam("room_id") int theId) {
		ModelAndView model = new ModelAndView("room/room list/room-form");

		Room room_model =this.room;
		
		if(room_model ==null) {			
			room_model = roomService.findbyId(theId);
			if(room_model ==null) new Room();
		}
		this.room = room_model;
		
		model.addObject("room_object", room_model);
		model.addObject("room_shifts", room_model.getRoom_shiftList());
		return model;
	}

	@GetMapping("/delete")
	private String Room_Delete() {
		return "redirect:/room/form";
	}

	/********************************* Mapping for roomBreak ******************/

	// request mapping for room list
	@GetMapping("/break/list")
	public String RoomBreak_List() {
		return "room/room breaktime/room-break";
	}

	@GetMapping("/break/form")
	public String RoomBreak_Form() {
		return "room/room breaktime/room-break-form";
	}

	// request mapping for room add
	@PostMapping("/break/add")
	public String RoomBreak_Add() {
		return "redirect:/room/break/form";
	}

	@GetMapping("/break/update")
	private String RoomBreak_Update() {
		return "redirect:/room/break/form";
	}

	@GetMapping("/break/delete")
	private String RoomBreak_Delete() {
		return "redirect:/room/break/form";
	}

	/********************************* Mapping for roomShift ******************/

	// request mapping for room list
	@GetMapping("/shift/list")
	public ModelAndView RoomShift_List() {
		ModelAndView model = new ModelAndView("room/room shift/room-shift");
		model.addObject("room_shifts", roomShiftService.findAll());
		return model;
	}

	@GetMapping("/shift/form")
	public String RoomShift_Form() {
		Room_Shift room = new Room_Shift();

		return "room/room shift/room-shift-form";
	}

	// request mapping for room add
	@PostMapping("/shift/add")
	public String RoomShift_Add() {

		return "redirect:/room/shift/form";
	}

	@GetMapping("/shift/update")
	private String RoomShift_Update() {
		return "redirect:/room/shift/form";
	}

	@GetMapping("/shift/delete")
	private String RoomShift_Delete(int theId) {
		roomShiftService.deleteById(theId);
		return "redirect:/room/shift/form";
	}

	/********************************* Mapping for Room Schedule ******************/

	@GetMapping("/schedule/list")
	public String RoomSchedule_List() {
		return "room/room shift schedule/room-schedule";
	}

	@GetMapping("/schedule/form")
	public String RoomSchedule_Form() {

		return "room/room shift schedule/room-schedule-form";
	}

	// request mapping for room add
	@PostMapping("/schedule/add")
	public String RoomSchedule_Add() {
		Room_Shift room = new Room_Shift();

		return "redirect:/room/schedule/form";
	}

	@GetMapping("/schedule/update")
	private String RoomSchedule_Update() {
		return "redirect:/room/schedule/form";
	}

	@GetMapping("/schedule/delete")
	private String RoomSchedule_Delete(int theId) {
		roomShiftService.deleteById(theId);
		return "redirect:/room/schedule/form";
	}

}
