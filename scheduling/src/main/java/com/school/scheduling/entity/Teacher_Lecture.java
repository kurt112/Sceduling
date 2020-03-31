package com.school.scheduling.entity;

import javax.persistence.*;

@Entity
@Table(name = "teacher_lecture")
public class Teacher_Lecture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "lecture_day")
	private String lectureDay;
	
	@Column(name = "start_time")
	private String startTime;
	
	@Column(name = "end_time")
	private String endTime;
	
	@Column(name = "remaining_time")
	private String remainingtTime;

	
	@ManyToOne(cascade ={
				CascadeType.DETACH,
				CascadeType.MERGE,
				CascadeType.PERSIST,
				CascadeType.REFRESH
				})
	@JoinColumn(name = "teacher_data")
	private Teacher teacher;
	
	
	
	public Teacher_Lecture() {
		
	}

	public Teacher_Lecture(int id, Teacher teacher, String lectureDay, String startTime, String endTime,
			String remainingtTime) {
		this.id = id;
		this.teacher = teacher;
		this.lectureDay = lectureDay;
		this.startTime = startTime;
		this.endTime = endTime;
		this.remainingtTime = remainingtTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getLectureDay() {
		return lectureDay;
	}

	public void setLectureDay(String lectureDay) {
		this.lectureDay = lectureDay;
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

	public String getRemainingtTime() {
		return remainingtTime;
	}

	public void setRemainingtTime(String remainingtTime) {
		this.remainingtTime = remainingtTime;
	}
	
	
	
	

}
