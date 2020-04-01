package com.school.scheduling.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "break_time")
public class BreakTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name ="start_time")
	private String start_time;
	
	@Column(name ="end_time")
	private String end_time;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH,CascadeType.PERSIST})
	@JoinTable(name = "teacher_breaktime", joinColumns = @JoinColumn(name = "break_time_id"), inverseJoinColumns = @JoinColumn(name = "teacher_shift_id"))
	private List<Teacher_Lecture> teacher_lecture;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL})
	@JoinTable(name = "room_shift_breaktime", joinColumns = @JoinColumn(name = "break_id"), inverseJoinColumns = @JoinColumn(name = "room_shift_id"))
	private List<Room_Shift> room_shift;

	public BreakTime() {

	}
	
	public BreakTime(String start_time, String end_time) {
		this.start_time = start_time;
		this.end_time = end_time;
	}
	
	public void Add_RoomShift(Room_Shift room) {
		if(room_shift == null) room_shift = new ArrayList<>();
		
		room_shift.add(room);
	
	}

	
	public void Add_TeacherLecture(Teacher_Lecture teacher) {
		if(teacher_lecture == null) teacher_lecture = new ArrayList<>();
		
		teacher_lecture.add(teacher);
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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


	public List<Teacher_Lecture> getTeacher_lecture() {
		return teacher_lecture;
	}

	public void setTeacher_lecture(List<Teacher_Lecture> teacher_lecture) {
		this.teacher_lecture = teacher_lecture;
	}

	public List<Room_Shift> getRoom_shift() {
		return room_shift;
	}

	public void setRoom_shift(List<Room_Shift> room_shift) {
		this.room_shift = room_shift;}
	
	@Override
	public boolean equals(Object object) {

		if (!(object instanceof BreakTime)) return false;
		
		BreakTime break_time = (BreakTime) object;
		return break_time.getId() == getId();
	}

}
