package com.school.scheduling.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "teacher_lecture")
public class Teacher_Lecture  implements Comparable<Teacher_Lecture>{
	
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
	
	
	@ManyToOne(cascade ={
				CascadeType.DETACH,
				CascadeType.MERGE,
				CascadeType.PERSIST,
				CascadeType.REFRESH
				})
	@JoinColumn(name = "teacher_data")
	private Teacher teacher;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(fetch = FetchType.LAZY,
	cascade = {
			CascadeType.DETACH,
			CascadeType.MERGE, 
			CascadeType.PERSIST,
			CascadeType.REFRESH
			})
	@JoinTable(
			name = "teacher_breaktime",
			joinColumns = @JoinColumn(name = "teacher_shift_id"),
			inverseJoinColumns = @JoinColumn(name = "break_time_id")
			)
	private List<BreakTime> breaktime_teacherList;
	
	public Teacher_Lecture() {
		
	}

	public Teacher_Lecture(int id, Teacher teacher, String lectureDay, String startTime, String endTime) {
		this.id = id;
		this.teacher = teacher;
		this.lectureDay = lectureDay;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	
	public void Add_Breaktime(BreakTime breaktime) {
		
		if(breaktime_teacherList == null) breaktime_teacherList = new ArrayList<>();
		
		breaktime_teacherList.add(breaktime);
		
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

	public List<BreakTime> getBreaktime_teacherList() {
		return breaktime_teacherList;
	}

	public void setBreaktime_teacherList(List<BreakTime> breaktime_teacherList) {
		this.breaktime_teacherList = breaktime_teacherList;
	}
	@Override
	public boolean equals(Object object) {

		if (!(object instanceof Teacher_Lecture)) return false;
		
		Teacher_Lecture teacher = (Teacher_Lecture) object;
		return teacher.getId() == id;
		
	}

	@Override
	public int compareTo(Teacher_Lecture o) {
	
		return startTime.compareToIgnoreCase(o.getStartTime());
	}
	
	
	

}
