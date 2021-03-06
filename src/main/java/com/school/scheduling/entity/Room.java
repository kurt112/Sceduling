/*
 * This code is created By Kurt Lupin C. Orioque
 * You can Contact me
 * Email: kurtorioque112@gmail.com
 * Contact: 09276913995
 * February , 11 2020
 * 12:31 PM
 */
package com.school.scheduling.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "room_name")
	private String roomName;

	@JsonIgnore
	@OneToMany(mappedBy = "room")
	private List<Room_Shift> room_shiftList;

	public Room() {
	}

	public Room(String roomName) {
		this.roomName = roomName;

	}

	public void addRoomShift(Room_Shift room_shift) {
		if (room_shiftList == null)
			room_shiftList = new ArrayList<>();
		room_shiftList.add(room_shift);
		room_shift.setRoom(this);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public List<Room_Shift> getRoom_shiftList() {
		return room_shiftList;
	}

	public void setRoom_shiftList(List<Room_Shift> room_shiftList) {
		this.room_shiftList = room_shiftList;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", roomName=" + roomName + ", room_shiftList=" + room_shiftList + "]";
	}

}
