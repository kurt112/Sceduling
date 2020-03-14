package com.school.scheduling.entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
 * This code is created By Kurt Lupin C. Orioque
 * You can Contact me
 * Email: kurtorioque112@gmail.com
 * Contact: 09276913995
 * February , 13 2020
 * 2:23 AM
 */

@Entity
@Table(name = "room_shift")
public class Room_Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "shift_name")
    private String shiftName;

    @Column(name = "grade")
    private String grade;

    @Column(name = "section")
    private String section;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    @OneToMany(mappedBy = "room_shift", cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private List<Room_Shift_BreakTime> room_shift_breakTimeList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "strand_and_course_id")
    private StrandAndCourse strandAndCourse;

    @OneToMany(mappedBy = "room_shift",cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private List<Student> studentList;



    public Room_Shift() {
    }

    public Room_Shift(String shiftName, String startTime, String endTime) {
        this.shiftName = shiftName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void add_Student(Student student){
        if(studentList == null) studentList = new ArrayList<>();
        studentList.add(student);
        student.setRoom_shift(this);
    }

    public void add_ShiftBreak(Room_Shift_BreakTime room_shift_breakTime){
        if(room_shift_breakTimeList == null) room_shift_breakTimeList = new ArrayList<>();
        room_shift_breakTimeList.add(room_shift_breakTime);
        room_shift_breakTime.setRoom_shift(this);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
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

    public List<Room_Shift_BreakTime> getRoom_shift_breakTimeList() {
        return room_shift_breakTimeList;
    }

    public void setRoom_shift_breakTimeList(List<Room_Shift_BreakTime> room_shift_breakTimeList) {
        this.room_shift_breakTimeList = room_shift_breakTimeList;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public StrandAndCourse getStrandAndCourse() {
        return strandAndCourse;
    }

    public void setStrandAndCourse(StrandAndCourse strandAndCourse) {
        this.strandAndCourse = strandAndCourse;
    }
}
