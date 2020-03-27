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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.school.scheduling.validations.CheckTime_RoomShift;

import javax.persistence.JoinColumn;
/*
 * This code is created By Kurt Lupin C. Orioque
 * You can Contact me
 * Email: kurtorioque112@gmail.com
 * Contact: 09276913995
 * February , 11 2020
 * 12:31 PM
 */
@Entity
//@Check_Time(message = "BreakTime should be")
@Table(name = "subject")
public class Subject {
	
	@Min(0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @NotNull(message = "(Please insert a name)")  
    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "subject_code")
    private String subjectCode;

    @Min(0)
    @Max(4)
    @Column(name = "subject_hour_cost")
    private int hourCost;
    
    @Min(0)
    @Max(59)
    @Column(name = "subject_minute_cost")
    private int minuteCost;

    @Column(name = "subject_unit")
    private String subjectUnit;
    
 
    @NotNull(message = "( Choose first )")
    @Column(name = "is_major")
   
    private String is_Major;


    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(fetch=FetchType.LAZY, cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinTable(
            name = "teacher_subjects",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<Teacher> teacherList;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(fetch=FetchType.LAZY, cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH,
    })
    @JoinTable(
            name = "strandandcourse_subject",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "strand_and_course_id")
    )
    private List<StrandAndCourse> strandAndCourseList;
  
    @OneToOne(mappedBy = "subject",cascade = {
    		CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH
    })
    private Room_ShiftSchedule room_ShiftSchedule;

    public Subject() {
    }
    
    
    
    public Subject(int id, String subjectName, String subjectCode, int hourCost, int minuteCost, String subjectUnit,
			String is_major) {
	
		Id = id;
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
		this.hourCost = hourCost;
		this.minuteCost = minuteCost;
		this.subjectUnit = subjectUnit;
		this.is_Major = is_major;
	}



	public void add_Strand(StrandAndCourse strandAndCourse){
        if(strandAndCourseList == null) strandAndCourseList = new ArrayList<>();

        strandAndCourseList.add(strandAndCourse);
    }

    public void addTeacher(Teacher teacher){
        if(teacherList==null) teacherList = new ArrayList<>();
    }
    
    

    public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public int getHourCost() {
		return hourCost;
	}

	public void setHourCost(int hourCost) {
		this.hourCost = hourCost;
	}

	public int getMinuteCost() {
		return minuteCost;
	}

	public void setMinuteCost(int minuteCost) {
		this.minuteCost = minuteCost;
	}

	public String getSubjectUnit() {
		return subjectUnit;
	}

	public void setSubjectUnit(String subjectUnit) {
		this.subjectUnit = subjectUnit;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	public List<StrandAndCourse> getStrandAndCourseList() {
		return strandAndCourseList;
	}

	public void setStrandAndCourseList(List<StrandAndCourse> strandAndCourseList) {
		this.strandAndCourseList = strandAndCourseList;
	}
	
	
	
	public String getIs_Major() {
		return is_Major;
	}



	public void setIs_Major(String is_Major) {
		this.is_Major = is_Major;
	}
	
	

	public Room_ShiftSchedule getRoom_ShiftSchedule() {
		return room_ShiftSchedule;
	}



	public void setRoom_ShiftSchedule(Room_ShiftSchedule room_ShiftSchedule) {
		this.room_ShiftSchedule = room_ShiftSchedule;
	}



	@Override
	public String toString() {
		return "Subject [Id=" + Id + ", subjectName=" + subjectName + ", subjectCode=" + subjectCode + ", hourCost="
				+ hourCost + ", minuteCost=" + minuteCost + ", subjectUnit=" + subjectUnit + ", is_Major=" + is_Major
				+ ", teacherList=" +  ", strandAndCourseList="
				+ strandAndCourseList + "]";
	}
	
	
	
	
	
	



	
	
	

	
}
