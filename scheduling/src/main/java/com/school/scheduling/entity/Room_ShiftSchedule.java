package com.school.scheduling.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "room_shift_schedule")
public class Room_ShiftSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(cascade ={
				CascadeType.DETACH,
				CascadeType.MERGE,
				CascadeType.PERSIST,
				CascadeType.REFRESH
				})
	@JoinColumn(name = "room_shift")
	private Room_Shift room_shift;

	@ManyToOne(cascade ={
				CascadeType.DETACH,
				CascadeType.MERGE,
				CascadeType.PERSIST,
				CascadeType.REFRESH
				})
	@JoinColumn(name= "teacher_id")
	private Teacher teacher;

	@OneToOne(cascade = {
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH
	})
	@JoinColumn(name = "subject_id")
	private Subject subject;

	@Column(name = "start_time")
	private String start_time;

	@Column(name = "end_time")
	private String end_time;

	@Column(name = "lecture_day")
	private String lecture_day;

	
	
	public Room_ShiftSchedule(Room_Shift room_shift,Subject subject, String start_time,
			String end_time, String lecture_day) {
		this.room_shift = room_shift;
		this.subject = subject;
		this.start_time = start_time;
		this.end_time = end_time;
		this.lecture_day = lecture_day;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Room_Shift getRoom_shift() {
		return room_shift;
	}

	public void setRoom_shift(Room_Shift room_shift) {
		this.room_shift = room_shift;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getLecture_day() {
		return lecture_day;
	}

	public void setLecture_day(String lecture_day) {
		this.lecture_day = lecture_day;
	}
}
