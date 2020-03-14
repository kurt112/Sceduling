package com.school.scheduling.entity;
import javax.persistence.*;

/*
 * This code is created By Kurt Lupin C. Orioque
 * You can Contact me
 * Email: kurtorioque112@gmail.com
 * Contact: 09276913995
 * February , 13 2020
 * 2:28 AM
 */
@Entity
@Table(name = "room_shift_breaktime")
public class Room_Shift_BreakTime {

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
    @JoinColumn(name = "room_shift_id")
    private Room_Shift room_shift;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    public Room_Shift_BreakTime() {

    }

    public Room_Shift_BreakTime(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room_Shift getRoom_shift() {
        return room_shift;
    }

    public void setRoom_shift(Room_Shift room_shift) {
        this.room_shift = room_shift;
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
}
