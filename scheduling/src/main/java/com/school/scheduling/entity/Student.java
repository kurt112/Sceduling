package com.school.scheduling.entity;
import javax.persistence.*;

/*
 * This code is created By Kurt Lupin C. Orioque
 * You can Contact me
 * Email: kurtorioque112@gmail.com
 * Contact: 09276913995
 * February , 11 2020
 * 12:31 PM
 */
@Entity
@Table(name = "student")
public class Student {

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


    @ManyToOne(fetch = FetchType.LAZY, cascade = {
    		CascadeType.DETACH,
    		CascadeType.MERGE,
    		CascadeType.REFRESH,
    		CascadeType.PERSIST
    })
    @JoinColumn(name = "strand_and_course_id")
    private StrandAndCourse strandAndCourse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_shift_id")
    private Room_Shift room_shift;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private Users users;

    public Student() {
    }

    public Student(String firstName, String lastName, String sex) {
        System.out.println("asdasd");
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
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


    public StrandAndCourse getStrandAndCourse() {
        return strandAndCourse;
    }

    public void setStrandAndCourse(StrandAndCourse strandAndCourse) {
        this.strandAndCourse = strandAndCourse;
    }

    public Room_Shift getRoom_shift() {
        return room_shift;
    }

    public void setRoom_shift(Room_Shift room_shift) {
        this.room_shift = room_shift;
    }

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
    
    
}
