package com.school.scheduling.entity;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "sex")
    private String sex;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;
    
    @Column(name = "remaining_time")
    private String remainingTime;
    
    @Column(name = "lecture_day")
    private String lecture_day;


    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinTable(
            name = "teacher_subjects",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjectList;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(fetch = FetchType.LAZY,
	cascade = {
			CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH
			})
	@JoinTable(
			name = "teacher_breaktime",
			joinColumns = @JoinColumn(name = "teacher_id"),
			inverseJoinColumns = @JoinColumn(name = "break_time_id")
			)
	private List<BreakTime> breaktime_teacherList;

	


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_name")
    private Users users;
    public Teacher (){

    }

    public Teacher(String firstName, String lastName, String sex, String startTime, String endTime, String lecture_day) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.startTime = startTime;
        this.endTime = endTime;
        this.lecture_day = lecture_day;
    }

    public void add_BreakTime(BreakTime breaktime_teacher){

        if(breaktime_teacherList == null) breaktime_teacherList = new ArrayList<>();
        breaktime_teacherList.add(breaktime_teacher);


    }


    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public void add_Subject(Subject subject){
        if(subjectList == null) subjectList = new ArrayList<>();
        subjectList.add(subject);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
    	this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public List<BreakTime> getBreaktime_teacherList() {
        return breaktime_teacherList;
    }

    public void setBreaktime_teacherList(List<BreakTime> breaktime_teacherList) {
        this.breaktime_teacherList = breaktime_teacherList;
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

    public String getLecture_day() {
		return lecture_day;
	}

	public void setLecture_day(String lecture_day) {
		this.lecture_day = lecture_day;
	}

	public String getRemainingTime() {
		return remainingTime;
	}

	public void setRemainingTime(String remainingTime) {
		this.remainingTime = remainingTime;
	}

	@Override
    public String toString() {
        return "Teacher{" +
                "Id=" + id +
                ", FirstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", Sex='" + sex + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", breaktime_teacherList=" + breaktime_teacherList +
//                ", subjectList=" + subjectList +
                '}';
    }
}
