package com.school.scheduling.entity;
import javax.persistence.*;

/*
 * This code is created By Kurt Lupin C. Orioque
 * You can Contact me
 * Email: kurtorioque112@gmail.com
 * Contact: 09276913995
 * February , 13 2020
 * 2:56 AM
 */
@Entity
@Table(name = "teacher_schedule")
public class Teacher_Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "teacher_subjects_id")
    private Teacher teacher;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String EndTime;
 
    @Column(name = "lecture_day")
    private String lecture_day;
    
    public Teacher_Schedule() {
    }

    public Teacher_Schedule(Teacher teacher, String startTime, String endTime) {
        this.teacher = teacher;
        this.startTime = startTime;
        EndTime = endTime;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

	public String getLecture_day() {
		return lecture_day;
	}

	public void setLecture_day(String lecture_day) {
		this.lecture_day = lecture_day;
	}
    
    
}
