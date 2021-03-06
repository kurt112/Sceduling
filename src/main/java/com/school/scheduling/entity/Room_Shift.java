package com.school.scheduling.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.scheduling.validations.RoomShift.CheckTime_RoomShift;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * This code is created By Kurt Lupin C. Orioque
 * You can Contact me
 * Email: kurtorioque112@gmail.com
 * Contact: 09276913995
 * February , 13 2020
 * 2:23 AM
 */
@CheckTime_RoomShift
@Entity
@Table(name = "room_shift")
public class Room_Shift implements Comparable<Room_Shift>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int Id;


	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST })
	@JoinColumn(name = "room_id")
	private Room room;

	@Column(name = "shift_name")
	private String shiftName;

	@Column(name = "grade")
	private String grade;

	@Column(name = "section")
	private String section;

	@Column(name = "start_time")
	private String startTime;

	@Column(name = "end_time")
	private String endTime;
	
	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
	@JoinTable(name = "room_shift_breaktime", joinColumns = @JoinColumn(name = "room_shift_id"), inverseJoinColumns = @JoinColumn(name = "break_id"))
	private List<BreakTime> room_shift_breakTimeList;

	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST })
	@JoinColumn(name = "strand_and_course_id")
	private StrandAndCourse strandAndCourse;

	@JsonIgnore
	@OneToMany(mappedBy = "room_shift", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST })
	private List<Student> studentList;
	
	@JsonIgnore
	@OneToMany(mappedBy = "room_shift", cascade = {
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH
	})
	private List<Room_ShiftSchedule> room_ShiftSchedules;


	@Column(name ="initial_time")
	private String initial_time;
	
	public Room_Shift() {
	}

	public Room_Shift(String shiftName, String startTime, String endTime) {
		this.shiftName = shiftName;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public void add_Student(Student student) {
		if (studentList == null)
			studentList = new ArrayList<>();
		studentList.add(student);
		student.setRoom_shift(this);
	}

	public void add_ShiftBreak(BreakTime breaktime) {
		if (room_shift_breakTimeList == null)
			room_shift_breakTimeList = new ArrayList<>();
		room_shift_breakTimeList.add(breaktime);
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getShiftName() {
		return shiftName;
	}

	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List<BreakTime> getRoom_shift_breakTimeList() {
		return room_shift_breakTimeList;
	}

	public void setRoom_shift_breakTimeList(List<BreakTime> room_shift_breakTimeList) {
		this.room_shift_breakTimeList = room_shift_breakTimeList;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public StrandAndCourse getStrandAndCourse() {
		return strandAndCourse;
	}

	public void setStrandAndCourse(StrandAndCourse strandAndCourse) {
		this.strandAndCourse = strandAndCourse;
	}

	
	
	public List<Room_ShiftSchedule> getRoom_ShiftSchedules() {
		return room_ShiftSchedules;
	}

	public void setRoom_ShiftSchedules(List<Room_ShiftSchedule> room_ShiftSchedules) {
		this.room_ShiftSchedules = room_ShiftSchedules;
	}
	
	public String getInitial_time() {
		return initial_time;
	}

	public void setInitial_time(String initial_time) {
		this.initial_time = initial_time;
	}

	@Override
	public int compareTo(Room_Shift o) {

		return 0;
	}


}
