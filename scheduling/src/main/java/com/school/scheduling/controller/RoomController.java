package com.school.scheduling.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
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
import org.springframework.web.servlet.ModelAndView;

import com.school.scheduling.SchedulingAlgorithm.GenerateRoomShift_Schedule;
import com.school.scheduling.entity.BreakTime;
import com.school.scheduling.entity.Room;
import com.school.scheduling.entity.Room_Shift;
import com.school.scheduling.entity.Room_ShiftSchedule;
import com.school.scheduling.entity.StrandAndCourse;
import com.school.scheduling.entity.Student;
import com.school.scheduling.service.Services;

@Controller()
@RequestMapping("/room")
public class RoomController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	/********************** For Room list ******************************/
	private Services<BreakTime> breakService;

	private Services<Room> roomService;
	private Services<Room_Shift> roomShiftService;
	private Services<StrandAndCourse> strandService;
	private Services<Room_ShiftSchedule> shiftSchedule;
	private Room room;
	private Room_Shift roomShift;
	private Room_Shift delete_shift;

	@Autowired
	public RoomController(Services<Room> roomService, Services<Room_Shift> roomShiftService,
			Services<StrandAndCourse> strandService, Services<BreakTime> breakService,
			Services<Room_ShiftSchedule> shiftSchedule) {
		this.roomService = roomService;
		this.roomShiftService = roomShiftService;
		this.strandService = strandService;
		this.breakService = breakService;
		this.shiftSchedule = shiftSchedule;
	}

	/********************************* Mapping for Room ******************/

	// request mapping for room list
	@GetMapping("/list")
	public String RoomList(Model model) {
		model.addAttribute("rooms", roomService.findAll());
		this.room = null;
		return "room/room list/room-list";

	}

	// request mapping for room add
	@GetMapping("/form")
	public String Room_Form(Model model) {
		this.room = new Room();
		model.addAttribute("room_object", this.room);

		model.addAttribute("action", "Save Room");
		return "room/room list/room-form";

	}

	@PostMapping("/save")
	public String Room_Save(@ModelAttribute("room_object") Room room, Model model, BindingResult binding) {
		this.room.setRoomName(room.getRoomName());
		roomService.save(this.room);

		return "redirect:/room/form";
	}

	@GetMapping("/update")
	private ModelAndView Room_Update(@RequestParam("room_id") int theId) {
		ModelAndView model = new ModelAndView("room/room list/room-form");

		Room room_model = this.room;
		try {
			// trying to find the object in the form created
			if (room_model.getRoomName() == null) {
				room_model = roomService.findbyId(theId);
				if (room_model == null)
					new Room();
			}
		} catch (NullPointerException e) {
			// if the new object in the form not created we
			// will find it in the database
			room_model = roomService.findbyId(theId);
		}
		this.room = room_model;

		model.addObject("room_object", room_model);
		model.addObject("room_shifts", room_model.getRoom_shiftList());

		model.addObject("action", "Update Room");
		return model;
	}

	@GetMapping("/delete")
	private String Room_Delete(@RequestParam("room_id") int theId) {

		roomService.deleteById(theId);

		return "redirect:/room/form";
	}

	@GetMapping("/deleteMain")
	private String Room_DeleteMain(@RequestParam("room_id") int theId) {
		roomService.deleteById(theId);

		return "redirect:/room/list";
	}

	/********************************* Mapping for roomBreak ******************/

	// request mapping for room list
	@GetMapping("/break/list")
	public String RoomBreak_List(Model model) {

		model.addAttribute("room_shift", roomShiftService.findAll());
		return "room/room breaktime/room-break";
	}

	@GetMapping("/break/form")
	public String RoomBreak_Form(Model model) {

		model.addAttribute("break_object", new BreakTime());
		model.addAttribute("action", "Save");
		return "room/room breaktime/room-break-form";
	}

	@GetMapping("/break/update")
	private String RoomBreak_Update() {
		return "redirect:/room/break/form";
	}

	@GetMapping("/break/delete")
	private String RoomBreak_DeleteMain(@RequestParam("break_id") int breakId,
			@RequestParam("shift_id") int roomshiftId) {
		Room_Shift shift = roomShiftService.findbyId(roomshiftId);

		shift.getRoom_shift_breakTimeList().removeIf(e -> e.getId() == breakId);

		roomShiftService.save(shift);

		return "redirect:/room/break/list";
	}

	@GetMapping("/break/deleteShiftForm")
	private String RoomBreakShift_Delete(@RequestParam("break_id") int breakId,
			@RequestParam("shift_id") int roomshiftId, Model model) {
		Room_Shift shift = roomShiftService.findbyId(roomshiftId);

		shift.getRoom_shift_breakTimeList().removeIf(e -> e.getId() == breakId);

		roomShiftService.save(shift);
		// the object in the form
		model.addAttribute("roomShift_object", shift);

		// the dropdown in the form
		model.addAttribute("room_list", roomService.findAll());
		model.addAttribute("strand_list", strandService.findAll());

		// state of the button
		model.addAttribute("action", "Update Shift");

		System.out.println(shift.getStudentList());
		model.addAttribute("student_list", shift.getStudentList());
		this.roomShift = shift;

		return "room/room shift/room-shift-form";
	}

	@GetMapping("/break/list/add")
	public String RoomBreak_ListAdd(@ModelAttribute("shift_object") Room_Shift room, Model model) {
		room = this.roomShift;
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");

		Calendar shift_startTime = Calendar.getInstance();
		Calendar shift_endTime = Calendar.getInstance();

		Calendar shift_break_start = Calendar.getInstance();
		Calendar shift_break_end = Calendar.getInstance();

		List<BreakTime> break_list = new ArrayList<BreakTime>();

		try {

			// he time of the shift list
			shift_startTime.setTime(dateFormat.parse(room.getStartTime()));
			shift_endTime.setTime(dateFormat.parse(room.getEndTime()));

			// it will check if the break is between the time of the room shift
			// .collect(Collectors.toList());
			for (BreakTime shift_break : breakService.findAll()) {

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

		break_list.removeAll(room.getRoom_shift_breakTimeList());

		model.addAttribute("room_breaks", break_list);

		model.addAttribute("shift_object", room);
		return "room/room breaktime/room-break-check";
	}

	@PostMapping("/break/list/save")
	public String RoomBreak_AddShift(@ModelAttribute("shift_object") Room_Shift roomShift, Model model) {

//		this.roomShift.getRoom_shift_breakTimeList().addAll(roomShift.getRoom_shift_breakTimeList());
		roomShift.getRoom_shift_breakTimeList().forEach(e -> this.roomShift.getRoom_shift_breakTimeList().add(e));

//		System.out.println(roomShift.toString());

		roomShiftService.save(this.roomShift);
//		System.out.println("The name " + this.roomShift.getShiftName());
		roomShift.getRoom_shift_breakTimeList().forEach(e -> System.out.println(e.getStart_time()));

		return "redirect:/room/shift/update?roomShift_id=" + this.roomShift.getId();
	}

	/********************************* Mapping for roomShift ******************/

	// request mapping for room Shift ksut list
	@GetMapping("/shift/list")
	public ModelAndView RoomShift_List() {

		ModelAndView model = new ModelAndView("room/room shift/room-shift");
		if (delete_shift != null) {
			roomShiftService.delete(this.delete_shift);
			delete_shift = null;
		}
		// getting all of the room shift
		model.addObject("room_shifts", roomShiftService.findAll());
		this.room = null;
		return model;
	}

	@GetMapping("/shift/student_form")
	public String RoomShift_StudentForm(Model model) {

		// for the dropdown
		model.addAttribute("strand_list", this.roomShift.getStrandAndCourse());
		model.addAttribute("roomshift_list", this.roomShift);

		// the object in the form
		model.addAttribute("student_object", new Student());

		return "student/student list/student-form";
	}

	@GetMapping("/shift/form")
	public String RoomShift_Form(Model model) {
		Room_Shift room_shift = new Room_Shift();

		// this is the model that will insert to the db
		model.addAttribute("roomShift_object", room_shift);

		// the dropdown item
		// dropdown of list room lsit'
		if (this.room != null) {
			model.addAttribute("room_list", this.room);
		} else {
			model.addAttribute("room_list", roomService.findAll());
		}
		// dropdown of list of strand list
		model.addAttribute("strand_list", strandService.findAll());

		// state of the button if it is update or Save
		model.addAttribute("action", "Save Shift");

		this.roomShift = room_shift;
		return "room/room shift/room-shift-form";
	}

	// request mapping of the shift save
	@PostMapping("/shift/save")
	public String RoomShift_Add(@Valid @ModelAttribute("roomShift_object") Room_Shift rooms_shift,
			BindingResult binding, Model model) {

		// chceck if the saving of shift has error
		System.out.println("the room " + this.room);
		if (binding.hasErrors()) {

			if (this.room != null) {
				model.addAttribute("room_list", this.room);
			} else {
				model.addAttribute("room_list", roomService.findAll());
			}

			model.addAttribute("strand_list", strandService.findAll());
			model.addAttribute("action", "Update Shift");
			return "room/room shift/room-shift-form";
		}
		roomShiftService.save(rooms_shift);

		return "redirect:/room/shift/form";
	}

	// request mapping for shift update
	@GetMapping("/shift/update")
	private String RoomShift_Update(@ModelAttribute("roomShift_id") int theId, Model model) {

		// finding the param id got in url
		Room_Shift room_shift = roomShiftService.findbyId(theId);

		// the object in the form
		model.addAttribute("roomShift_object", room_shift);

		// the dropdown in the form
		model.addAttribute("room_list", roomService.findAll());
		model.addAttribute("strand_list", strandService.findAll());

		// state of the button
		model.addAttribute("action", "Update Shift");

		// Room Shift Schedule
		model.addAttribute("shift_schedule", room_shift.getRoom_ShiftSchedules());

		System.out.println(room_shift.getStudentList());
		model.addAttribute("student_list", room_shift.getStudentList());
		this.roomShift = room_shift;

		return "room/room shift/room-shift-form";
	}

	// in this delete if the user delete in the acutal form
	@GetMapping("/shift/delete")
	private String RoomShift_Delete(@ModelAttribute("roomShift_id") int theId) {
		// deleting of the roomShift
		roomShiftService.deleteById(theId);
		return "redirect:/room/shift/form";
	}

	// in this delete if the user is delete in the main view
	@GetMapping("/shift/delete_Main")
	private String RoomShift_DeleteMain(@ModelAttribute("roomShift_id") int theId) {
		// finding the object of the list
		Room_Shift room = roomShiftService.findbyId(theId);

		// removing all of the student
		room.getStudentList().forEach(e -> {
			e.setRoom_shift(null);
		});

		// removing all of the breaktime of the sutdent
		room.getRoom_shift_breakTimeList().removeAll(room.getRoom_shift_breakTimeList());
		roomShiftService.save(room);
		this.delete_shift = room;
		return "redirect:/room/shift/list";
	}

	/********************************* Mapping for Room Schedule ******************/

	@GetMapping("/schedule/generate")
	public String GenerateSchedule() {
		
		GenerateRoomShift_Schedule shift_schedule = new GenerateRoomShift_Schedule(strandService.findAll(), roomShiftService.findAll(), roomShiftService, shiftSchedule);
		 shift_schedule.schedule();


		return"redirect:/room/schedule/list";
	}

	@GetMapping("/schedule/list")
	public String RoomSchedule_List(Model model) {

		List<Room_ShiftSchedule> sched = shiftSchedule.findAll();

		model.addAttribute("sched_list", sched);
		return "room/room shift schedule/room-schedule";
	}

	@GetMapping("/schedule/form")
	public String RoomSchedule_Form(Model model) {

		model.addAttribute("shift_schedule", new Room_ShiftSchedule());
		model.addAttribute("room_list", roomService.findAll());
		model.addAttribute("strand_list", strandService.findAll());
		model.addAttribute("action", "Add Schedule");
		return "room/room shift schedule/room-schedule-form";
	}

	// request mapping for room add
	@PostMapping("/schedule/add")
	public String RoomSchedule_Add(@ModelAttribute("shift_schedule") Room_ShiftSchedule scheudle) {

		shiftSchedule.save(scheudle);

		return "redirect:/room/schedule/form";
	}

	@GetMapping("/schedule/update")
	private String RoomSchedule_Update(@RequestParam("schedule_id") int id, Model model) {
		Room_ShiftSchedule shift = shiftSchedule.findbyId(id);
		model.addAttribute("shift_schedule", shift);
		model.addAttribute("room_list", roomService.findAll());
		model.addAttribute("strand_list", strandService.findAll());
		model.addAttribute("action", "Update Schedule");
		model.addAttribute("teacher_id", 0);
		

		return "room/room shift schedule/room-schedule-form";
	}

	@GetMapping("/schedule/deleteMain")
	private String RoomSchedule_Delete(@RequestParam("schedule_id") int id) {
		shiftSchedule.deleteById(id);
		return "redirect:/room/schedule/list";
	}

}
