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
    
    @Column(name = "work_type")
    private String workType;

    
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.REFRESH)
    private List<Teacher_Lecture> teacher_lecture;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinTable(
            name = "teacher_subjects",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjectList;

	

	@OneToMany(mappedBy = "teacher", cascade = {
			CascadeType.DETACH,
			CascadeType.MERGE, 
			CascadeType.PERSIST,
			CascadeType.REFRESH
			
	})
	private List<Room_ShiftSchedule> teacher_schedule;
	


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_name")
    private Users users;
    public Teacher (){

    }

    public Teacher(String firstName, String lastName, String sex, String workType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.workType = workType;
      
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



	public List<Room_ShiftSchedule> getTeacher_schedule() {
		return teacher_schedule;
	}

	public void setTeacher_schedule(List<Room_ShiftSchedule> teacher_schedule) {
		this.teacher_schedule = teacher_schedule;
	}
	
	

	public List<Teacher_Lecture> getTeacher_lecture() {
		return teacher_lecture;
	}

	public void setTeacher_lecture(List<Teacher_Lecture> teacher_lecture) {
		this.teacher_lecture = teacher_lecture;
	}

	
	
	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof Teacher)) return false;
		
		Teacher teacher = (Teacher) object;
		return teacher.getId() == id;
		
	}


	
	
}
