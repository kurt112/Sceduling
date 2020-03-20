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
    private int Id;

    @Column(name = "first_name")
    private String FirstName;

    @Column(name = "last_name")
    private String LastName;

    @Column(name = "sex")
    private String Sex;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Teacher_Schedule> teacher_scheduleList;

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

    public Teacher(String firstName, String lastName, String sex, String startTime, String endTime) {
        FirstName = firstName;
        LastName = lastName;
        Sex = sex;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void add_BreakTime(BreakTime breaktime_teacher){

        if(breaktime_teacherList == null) breaktime_teacherList = new ArrayList<>();
        breaktime_teacherList.add(breaktime_teacher);


    }

    public List<Teacher_Schedule> getTeacher_scheduleList() {
        return teacher_scheduleList;
    }

    public void setTeacher_scheduleList(List<Teacher_Schedule> teacher_scheduleList) {
        this.teacher_scheduleList = teacher_scheduleList;
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
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
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

  

    @Override
    public String toString() {
        return "Teacher{" +
                "Id=" + Id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Sex='" + Sex + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", breaktime_teacherList=" + breaktime_teacherList +
//                ", subjectList=" + subjectList +
                '}';
    }
}