package com.school.scheduling.entity;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/*
 * This code is created By Kurt Lupin C. Orioque
 * You can Contact me
 * Email: kurtorioque112@gmail.com
 * Contact: 09276913995
 * February , 11 2020
 * 12:31 PM
 */
@Entity
@Table(name = "strandandcourse")
public class StrandAndCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "strand_name")
    private String strandName;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY , cascade = 
    	{CascadeType.MERGE}
    )
    @JoinTable(
            name = "strandandcourse_subject", 
            joinColumns = @JoinColumn(name = "strand_and_course_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjectList;
    
    @OneToMany(mappedBy = "strandAndCourse", orphanRemoval = true
//    		,fetch = FetchType.LAZY
    		, cascade = CascadeType.ALL
    )
    private List<Student> studentList;

    @JsonIgnore
    @OneToMany(mappedBy = "strandAndCourse",
    		fetch = FetchType.LAZY)
    private List<Room_Shift> room_shiftList;
    public StrandAndCourse() {
    }

    public StrandAndCourse(String strandName) {
        this.strandName = strandName;
    }

    public void add_Subject(Subject subject){
        if(subjectList==null) subjectList = new ArrayList<>();

        subjectList.add(subject);

    }

    public void add_roomShift(Room_Shift room_shift){
        if(room_shiftList == null) room_shiftList = new ArrayList<>();
        room_shiftList.add(room_shift);

        room_shift.setStrandAndCourse(this);

    }

    public void add_student(Student student){
        if(studentList == null) studentList = new ArrayList<>();
        studentList.add(student);

        student.setStrandAndCourse(this);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStrandName() {
        return strandName;
    }

    public void setStrandName(String strandName) {
        this.strandName = strandName;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public List<Room_Shift> getRoom_shiftList() {
        return room_shiftList;
    }

    public void setRoom_shiftList(List<Room_Shift> room_shiftList) {
        this.room_shiftList = room_shiftList;
    }
    
    @Override
	public boolean equals(Object object) {

		if (!(object instanceof StrandAndCourse)) return false;
		
		StrandAndCourse strand = (StrandAndCourse) object;
		return strand.getId() == getId();
	}
}
